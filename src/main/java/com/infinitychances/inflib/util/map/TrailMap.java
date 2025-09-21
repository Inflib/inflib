package com.infinitychances.inflib.util.map;

import com.infinitychances.inflib.InfLib;
import com.infinitychances.inflib.annotations.MayReturnNull;
import com.infinitychances.inflib.annotations.VersionResistant;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Stream;

import static com.infinitychances.inflib.util.ReservedStuffManager.*;

/**
 * @param <V> the type of trailmap to be created
 * @since 0.3.0
 */
@VersionResistant
public class TrailMap<V> {
    private final List<String> keyList = new ArrayList<>();
    protected final ArrayList<ArrayList<Node<V>>> nodes = new ArrayList<>();
    private ArrayList<Node<V>> lastCheckedList = null;
    private String lastCheckedKey = null;

    private final Node<V> NULL_NODE = new Node<>(TrailToken.NULL_TOKEN, null, TrailToken.NULL_TOKEN, TrailToken.NULL_TOKEN);

    public TrailMap() {
    }

    private static TrailToken tokenize(String key, Integer id) {
        return new TrailToken(key, id);
    }

    private static MutablePair<String, Integer> deTokenize(TrailToken key) {
        MutableTriple<String, String, Integer> triple = key.getInfo();
        return MutablePair.of(triple.left, triple.right);
    }

    /**
     * Maps the values as nodes referencing each other, with a key
     * <p>Takes the {@code values} and turns them into a {@code Node}, which contains a {@code TrailToken}, which holds the token for
     * each node. Each node also contains previous and next values, which hold a {@code TrailToken} that refers to the
     * next and previous nodes, respectively. The node also holds the value itself. Then after creation of the nodes, they are placed in a
     * 2d arraylist, with each nested array containing all the nodes for the key. If an arraylist already exists for the key, then the nodes
     * are simply inserted into the arraylist.
     * @author InfinityChances
     * @param key the key that holds a specific trail of values
     * @param values all the values, in order from first to last, that are to go in said key
     *
     * @return The current instance of {@code TrailMap<T>}
     */
    @SafeVarargs
    public final TrailMap<V> map(String key, V... values) {
        lastCheckedKey = null;
        if (isReserved(key).getLeft()) {
            throw new IllegalArgumentException("Key must not contain any reserved characters! Character:" + isReserved(key).getRight());
        }
        if(!keyList.contains(key)) {
            ArrayList<Node<V>> nodes = new ArrayList<>();
            for (int i = 0; i < values.length; i++) {
                TrailToken token = tokenize(key, i);
                V value = values[i];
                Node<V> node = new Node<>(token, value, i+1 != values.length ? tokenize(key, i+1) : TrailToken.NULL_TOKEN, i != 0 ? tokenize(key, i-1) : TrailToken.NULL_TOKEN);
                nodes.add(node);
                if(i == 0) {
                    keyList.add(key);
                }
            }
            this.nodes.add(nodes);
        } else {
            ArrayList<Node<V>> list = findArrayList(key);
            if(list == null) throw new RuntimeException("No Arraylist found.");
            int arrayLen = list.toArray().length;
            for (int i = 0; i < values.length; i++) {
                TrailToken token = tokenize(key, i + arrayLen);
                V value = values[i];
                Node<V> node = new Node<>(token, value, i+1 != values.length ? tokenize(key, i+1+arrayLen) : TrailToken.NULL_TOKEN, tokenize(key, i-1+arrayLen));
                if(i == 0) {
                    getNodeFromId(key, arrayLen-1).setNext(token);
                }
                list.add(node);
            }
        }
        return this;
    }

    @SafeVarargs
    public final void insertAtBeginning(String key, V... values) {
        lastCheckedKey = null;
        if(!keyList.contains(key)) {
            InfLib.LOGGER.warn("TRAILMAP KEY NOT FOUND: " + key + " CREATING NEW STORAGE FOR KEY.");
            map(key, values);
            return;
        }
        ArrayList<Node<V>> currentList = findArrayList(key);
        currentList.getFirst().setPrevious(new TrailToken(key, values.length-1));
        for (int i = 0; i < currentList.toArray().length; i++) {
            Node<V> currentNode = currentList.get(i);
            currentNode.setPrevious(new TrailToken(key, currentNode.token.getID() + values.length -1));
            currentNode.setNext(new TrailToken(key, currentNode.token.getID() + values.length +1));
            currentNode.incrementToken(values.length);
        }
        for (int i = values.length-1; i >=0; i--) {
            Node<V> newNode = new Node<>(new TrailToken(key, i), values[i], new TrailToken(key, i+1), new TrailToken(key, i-1));
            if(i==0) {
                newNode.setPrevious(TrailToken.NULL_TOKEN);
            }
            currentList.addFirst(newNode);
        }
    }

    /**
     * Inserts the given value at an index inside a certain key
     *
     * @param key the key for a group of values
     * @param index the index being inserted at (starts at 0)
     * @param value the requested value to insert
     */
    public void insertAtIndex(String key, Integer index, V value) {
        lastCheckedKey = null;
        ArrayList<Node<V>> currentList = findArrayList(key);
        if(index == currentList.toArray().length) {
            insertAtEnd(key, value);
            return;
        }
        if(index == 0) {
            insertAtBeginning(key, value);
            return;
        }
        if(!keyList.contains(key)) {
            InfLib.LOGGER.error("NO KEY FOUND");
            throw new IllegalArgumentException("Key does not exist!");
        }

        TrailToken token = new TrailToken(key, index);

            Node<V> previousNode = getNodeFromId(key, index-1);
            previousNode.setNext(token);

        Node<V> inserted = new Node<>(token, value, new TrailToken(key, index+1), new TrailToken(key, index-1));
        for (int i = index; i < currentList.toArray().length; i++) {
            Node<V> currentNode = currentList.get(i);
            currentNode.incrementToken();
            currentNode.setPrevious(new TrailToken(key, currentNode.token.getID() -1));

            currentNode.setNext(new TrailToken(key, currentNode.token.getID() + 1));
        }
        currentList.add(index, inserted);
    }

    @SafeVarargs
    public final void insertAtIndex(String key, Integer index, V... values) {
        for(int i = values.length-1; i>=0; i--) {
            insertAtIndex(key, index, values[i]);
        }
    }

    @SafeVarargs
    public final void insertAtEnd(String key, V... values) {
        if(!keyList.contains(key)) {
            InfLib.LOGGER.warn("TRAILMAP KEY NOT FOUND: " + key + " CREATING NEW STORAGE FOR KEY.");
        }

        map(key, values);
    }

    @MayReturnNull
    public V getNextFromId(String key, Integer id) {
        Node<V> node = getNodeFromId(key, id);
        return node.next(this).getValue();
    }

    @MayReturnNull
    public V getPreviousFromId(String key, Integer id) {
        Node<V> node = getNodeFromId(key, id);
        return node.previous(this).getValue();
    }

    @MayReturnNull
    public V getFromId(String key, Integer id) {
        return getNodeFromId(key, id).getValue();
    }

    @MayReturnNull
    public V getNext(String key, V value) {
        return getNodeFromValue(key, value).next(this).getValue();
    }

    @MayReturnNull
    public V getPrevious(String key, V value) {
        return getNodeFromValue(key, value).previous(this).getValue();
    }

    protected Node<V> getNodeFromValue(String key, V value) {
        ArrayList<Node<V>> array;
        if(!Objects.equals(lastCheckedKey, key)) {
            array = findArrayList(key);
            lastCheckedList = array;
            lastCheckedKey = key;
        } else {
            array = lastCheckedList;
        }
        return array.stream().filter(x -> x.value.equals(value))
            .findFirst().orElseThrow();
    }

    protected Node<V> getNodeFromId(String key, Integer id) {
        TrailToken wanted = tokenize(key, id);
        if(!keyList.contains(key)) throw new IllegalArgumentException("Key does not exist: " + key);
        Optional<Node<V>> index = getNodeStream().filter(x -> x.token.equals(wanted)).findFirst();
        return index.orElseThrow();
    }

    private Node<V> getNodeFromToken(TrailToken token) {
        return getNodeFromId(token.getKey(), token.getID());
    }

    //Returns the 2d arraylist mapped into a 1d stream.
    private Stream<Node<V>> getNodeStream() {
        return nodes.stream().flatMap(ArrayList::stream);
    }

    /**
    * Iterates over each arraylist inside the 2d arraylist of nodes to find the arraylist that contains nodes for a specific key.
    * <p>It first streams the 2d arraylist to get each arraylist, then filters by streaming each list and looking for the node with the id of 0. Once it has that node,
     * it gets the key of it and compares it to the wanted key. If there is no arraylist found, it throws an error.</p>
    * @param key the key that contains a specific trail
     * @author InfinityChances
     *
    **/
    private ArrayList<Node<V>> findArrayList(String key) {
        if(!keyList.contains(key)) throw new IllegalArgumentException("Key does not exist: " + key);
        return nodes.stream().filter(
                x -> x.stream().filter(
                        y -> y.token.getID() == 0)
                        .findFirst().orElseThrow().token.getKey().equals(key)).findFirst().orElseThrow();
    }

    /**
     *
     */
    public void print() {
        InfLib.LOGGER.info(nodes.toString());
    }


    protected static class TrailToken {
        MutableTriple<String, String, Integer> triplet;

        public static final TrailToken NULL_TOKEN = new TrailToken();

        private TrailToken(String key, Integer id) {
            this.triplet = new MutableTriple<>(key, makeToken(key, id), id);
        }

        private TrailToken() {
            this.triplet = new MutableTriple<>(null, "null", null);
        }

        private static String makeToken(String key, Integer id) {
            return key + SPLIT_CHAR + id.toString();
        }

        public boolean equals(TrailToken k) {
            return Objects.equals(triplet.middle, k.triplet.middle);
        }

        private MutableTriple<String, String, Integer> getInfo() {
            return this.triplet;
        }

        private String getKey() {
            return this.triplet.left;
        }

        private String getToken() {
            return this.triplet.middle;
        }

        private Integer getID() {
            return this.triplet.right;
        }

        private void incrementId() {
            int newId = triplet.right + 1;
            triplet.setRight(newId);
            triplet.setMiddle(makeToken(triplet.left, newId));
        }
        private void incrementId(Integer amount) {
            int newId = triplet.right + amount;
            triplet.setRight(newId);
            triplet.setMiddle(makeToken(triplet.left, newId));
        }

        private void decrementId() {
            int newId = triplet.right - 1;
            triplet.setRight(newId);
            triplet.setMiddle(makeToken(triplet.left, newId));
        }
    }

    protected static class Node<V> {
        TrailToken token;
        V value;
        TrailToken next;
        TrailToken previous;

        public Node(TrailToken token, V value, @Nullable TrailToken next, @Nullable TrailToken previous) {
            this.token = token;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public void setNext(TrailToken next) {
            this.next = next;
        }

        public void setPrevious(TrailToken previous) {
            this.previous = previous;
        }

        public V getValue() {
            return value;
        }

        public TrailToken getToken() {
            return token;
        }

        @Override
        public String toString() {
            return "{ " + token.getInfo().toString() + " " + value.toString() + " " + next.getInfo().toString() + " " + previous.getInfo().toString() + " }";
        }

        public void incrementToken() {
            incrementToken(1);
        }

        public void incrementToken(Integer amount) {
            token.incrementId(amount);
        }

        public Node<V> next(TrailMap<V> map) {
            TrailToken nextToken = this.next;
            if(nextToken.equals(TrailToken.NULL_TOKEN)) return map.NULL_NODE;
            return map.getNodeFromToken(nextToken);
        }
        public Node<V> previous(TrailMap<V> map) {
            TrailToken previousToken = this.previous;
            if(previousToken.equals(TrailToken.NULL_TOKEN)) return map.NULL_NODE;
            return map.getNodeFromToken(previousToken);
        }

        public boolean equals(Node<V> other) {
            return value.equals(other.value) && token.equals(other.token);
        }
    }
}