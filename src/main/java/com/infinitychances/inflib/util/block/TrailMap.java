package com.infinitychances.inflib.util.block;

import com.infinitychances.inflib.InfLib;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

import static com.infinitychances.inflib.util.ReservedStuffManager.*;

public class TrailMap<V> {
    private final HashMap<String, Node<V>> startIndexMap = new HashMap<>();
    private final ArrayList<ArrayList<Node<V>>> nodes = new ArrayList<>();

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
     * @param key the key that holds a specific trail of values
     * @param values all the values, in order from first to last, that are to go in said key
     *
     * @return The current instance of {@code TrailMap<T>}
     */
    @SafeVarargs
    public final TrailMap<V> map(String key, V... values) {
        if (isReserved(key)) {
            throw new IllegalArgumentException("Key must not contain any reserved characters!");
        }
        if(!startIndexMap.containsKey(key)) {
            ArrayList<Node<V>> nodes = new ArrayList<>();
            for (int i = 0; i < values.length; i++) {
                TrailToken token = tokenize(key, i);
                V value = values[i];
                Node<V> node = new Node<>(token, value, i+1 != values.length ? tokenize(key, i+1) : TrailToken.NULL_TOKEN, i != 0 ? tokenize(key, i-1) : TrailToken.NULL_TOKEN);
                nodes.add(node);
                if(i == 0) {
                    startIndexMap.put(key, node);
                }
            }
            this.nodes.add(nodes);
        } else {
            ArrayList<Node<V>> list = nodes.stream().filter(
                            x -> x.stream().filter(
                                            y -> y.previous == TrailToken.NULL_TOKEN)
                                    .findAny().orElse(null) == startIndexMap.get(key))
                    .findAny().orElse(null);
            if(list == null) throw new RuntimeException("NodeStream returned null");
            Integer arrayLen = list.toArray().length;
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
    public final void insertAtEnd(String key, V... values) {
        if(!startIndexMap.containsKey(key)) {
            InfLib.LOGGER.warn("TRAILMAP KEY NOT FOUND: " + key + " CREATING NEW STORAGE FOR KEY.");
        }

        map(key, values);
    }

    protected Node<V> getNodeFromId(String key, Integer id) {
        TrailToken wanted = tokenize(key, id);
        if(!startIndexMap.containsKey(key)) throw new IllegalArgumentException("Key does not exist: " + key);
        Node<V> startNode = startIndexMap.get(key);
        if(startNode.token.equals(wanted)) {
            return startNode;
        }
        Optional<Node<V>> index = getNodeStream().filter(x -> x.token.equals(wanted)).findAny();
        return index.orElse(null);
    }

    //Returns the 2d arraylist mapped into a 1d stream.
    private final Stream<Node<V>> getNodeStream() {
        return nodes.stream().flatMap(ArrayList::stream);
    }

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
            this.triplet = new MutableTriple<>(null, null, null);
        }

        private static String makeToken(String key, Integer id) {
            return key + SPLIT_CHAR + id.toString();
        }

        public boolean equals(TrailToken k) {
            return triplet.middle.equals(k.triplet.middle);
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
            return token.getInfo().toString() + " " + value.toString() + " " + next.getInfo().toString() + " " + previous.getInfo().toString();
        }
    }
}