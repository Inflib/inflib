package com.infinitychances.inflib.util.block;

import com.infinitychances.inflib.InfLib;

import java.util.HashMap;
import static com.infinitychances.inflib.util.ReservedStuffManager.*;

public class TrailMap<T> {
    private HashMap<String, T> map = new HashMap<>();
    private HashMap<String, Integer> holdMap = new HashMap<>();
    
    public TrailMap() {}
    
    //Do not map empty ArrayLists, HashMaps, Maps, etc...
    @SafeVarargs
    public final TrailMap<T> map(String key, T... listOrder) {
        if(holdMap != null) {
            if(holdMap.containsKey(key)) {
                throw new IllegalArgumentException("Key cannot be the same as another one!");
            }
        }
        if(isReserved(key) || hasNumber(key)) {
            throw new IllegalArgumentException("Key cannot contain a reserved character or a number!");
        }
        int iterate = 0;
        for(T object : listOrder) {
            map.put(tokenize(key, iterate), object);
            iterate++;
        }
        holdMap.put(key, iterate);
        return this;
    }
    
    /*TOKEN HANDLERS*/

    public static String tokenize(String key, int count) {
        if(count < 0) {
            throw new IllegalArgumentException("cannot tokenize a negative value!");
        }
        return key + SPLIT_CHAR + count;
    }

    public static String tokenize(String key) {
        return tokenize(key, 0);
    }

    private static String[] detokenize(String token) {
        return token.split(SPLIT_CHAR);
    }
    
    /*MAIN TOOLS*/
    
    public T getFromIndex(String key, Integer index) {
        return map.get(tokenize(key, index));
    }
    
    public void replaceFromIndex(String key, Integer index, T item) {
        if(!map.containsKey(tokenize(key))) {
            throw new IllegalArgumentException("Key does not exist!");
        }
        if(!map.containsKey(tokenize(key, index))) {
            throw new IllegalArgumentException("Cannot create new values!");
        }
        map.replace(tokenize(key, index), item);
    }

    public T getNextFromIndex(String key, Integer index) {
        if(!map.containsKey(tokenize(key))) {
            throw new IllegalArgumentException("Key does not exist!");
        }
        return map.get(tokenize(key, index+1));
    }

    public T getNextInChain(String key, T item) {
        if(item == null) {
            throw new IllegalArgumentException("Item cannot be null!");
        }
        if(!map.containsKey(tokenize(key))) {
            throw new IllegalArgumentException("Key does not exist!");
        } else if (!map.containsValue(item)) {
            throw new IllegalArgumentException("Value does not exist!");
        }
        for(int i=0; i < holdMap.get(key); i++) {
            //inferences to get first value with same type.
            String newKey = tokenize(key, i);
            T currentCheck = map.get(tokenize(key, i+1));
            if(map.get(newKey).equals(item)) {
                return currentCheck;
            }
        }
        return null;
    }
    
    public T getPreviousFromIndex(String key, Integer index) {
        if(!map.containsKey(tokenize(key))) {
            throw new IllegalArgumentException("Key does not exist!");
        }
        return index < 1 ? null : map.get(tokenize(key, index-1));
    }
    
    public T getPreviousInChain(String key, T item) {
        if(item == null) {
            throw new IllegalArgumentException("Item cannot be null!");
        }
        if(!map.containsKey(tokenize(key))) {
            throw new IllegalArgumentException("Key does not exist!");
        } else if (!map.containsValue(item)) {
            throw new IllegalArgumentException("Value does not exist!");
        }
        for(int i=holdMap.get(key) - 1 ; i >= 0; i--) {
            //inferences to get first value with same type.
            String newKey = tokenize(key, i);
            T currentCheck = map.get(tokenize(key, i-1));
            if(map.get(newKey).equals(item)) {
                return currentCheck;
            }
        }
        return null;
    }
    
    public void addToEnd(String key, T item) {
        if(!map.containsKey(tokenize(key))) {
            throw new IllegalArgumentException("Key does not exist!");
        }
        Integer index = holdMap.get(key);
        map.put(tokenize(key, index), item);
        holdMap.replace(key, index+1);
    }
    
    public void insert(String key, Integer index, T item) {
        if(!map.containsKey(tokenize(key))) {
            throw new IllegalArgumentException("Key does not exist!");
        }
        index = Math.clamp(index, 0, holdMap.get(key));
        if(index.intValue() == holdMap.get(key).intValue()) {
            addToEnd(key, item);
            return;
        }
        for(int i = (holdMap.get(key) - 1); i >= index; i--) {
            map.put(tokenize(key, i+1), map.remove(tokenize(key, i)));
            //starts from the highest value, bumps them all up until there is one spot left for the new value
        }
        holdMap.replace(key, holdMap.get(key)+1);
        map.put(tokenize(key, index), item);
    }
    
    public void addToBeginning(String key, T item) {
        insert(key, 0, item);
    }
    
    /*LOOPED VERSIONS*/
    
    @SafeVarargs
    public final void addToEnd(String key, T... items) {
        for(T val : items) {
            addToEnd(key, val);
        }
    }
    
    @SafeVarargs
    public final void insert(String key, Integer index, T... items) {
        Integer i = index;
        for(T item : items) {
            insert(key, i, item);
            i++;
        }
    }
    
    @SafeVarargs
    public final void addToBeginning(String key, T... items) {
        for(int i = items.length - 1; i >= 0; i--) {
            addToBeginning(key, items[i]);
        }
    }
    
    /*STRING AND PRINT MANAGERS*/
    
    //creates the toString method to mention each key and value chain.
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(String key : holdMap.keySet()) {
            Integer count = holdMap.get(key);
            string.append("Key: ").append(key).append(";").append(" Values: ");
            for(int i = 0; i < count; i++) {
                String item = map.get(tokenize(key, i)).toString();
                string.append(item);
                if(i != count - 1) {
                    string.append(", ");
                } else {
                    string.append("; ");
                }
            }
        }
        return string.toString();
    }
    
    public void print() {
        InfLib.LOGGER.info(this.toString());
    }
    
    public void printKey(String key) {
        if(!map.containsKey(tokenize(key))) {
            throw new IllegalArgumentException("Key does not exist!");
        }
        //basically just the toString method.
        StringBuilder string = new StringBuilder();
        Integer count = holdMap.get(key);
        string.append("Key: ").append(key).append(";").append(" Values: ");
        for(int i = 0; i < count; i++) {
            String item = map.get(tokenize(key, i)).toString();
            string.append(item);
            if(i != count - 1) {
                string.append(", ");
            } else {
                string.append("; ");
            }
        }
        InfLib.LOGGER.info(string.toString());
    }
}