package com.infinitychances.inflib.util.block;

import java.util.HashMap;
import static com.infinitychances.inflib.util.ReservedStuffManager.*;

public class TrailMap<T> {
    private HashMap<String, T> map = new HashMap<>();
    private HashMap<String, Integer> holdMap = new HashMap<>();


    public TrailMap() {

    }

    private static String tokenize(String key, int count) {
        return key + SPLIT_CHAR + count;
    }

    private static String tokenize(String key) {
        return key + SPLIT_CHAR + 0;
    }

    private static String[] detokenize(String token) {
        return token.split(SPLIT_CHAR);
    }

    //Do not map empty ArrayLists, HashMaps, Maps, etc...
    @SafeVarargs
    public final void map(String key, T... listOrder) {
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
    }

    public T getFromIndex(String key, Integer index) {
        return map.get(tokenize(key, index));
    }

    public T getNextFromIndex(String key, Integer index) {
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
            T currentCheck = map.get(tokenize(key, Integer.parseInt(detokenize(newKey)[1])+1));
            if(map.get(newKey).equals(item)) {
                return currentCheck;
            }
        }
        return null;
    }
    
    
    
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
}