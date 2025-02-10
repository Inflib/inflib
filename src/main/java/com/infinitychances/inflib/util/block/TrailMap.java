package com.infinitychances.inflib.util.block;

import java.util.HashMap;
import static com.infinitychances.inflib.util.ReservedCharManager.*;

public class TrailMap<T> {
    public static final String SPLIT_CHAR = "≈";
    private HashMap<String, T> map;
    private HashMap<String, Integer> holdMap;

    public T next(T object) {
        return object;
    }

    public TrailMap() {}

    private static String tokenize(String key, int count) {
        return key + SPLIT_CHAR + count;
    }

    private static String[] detokenize(String token) {
        return token.split(SPLIT_CHAR);
    }

    public void map(String key, T... listOrder) {
        if(holdMap.containsKey(key)) {
            throw new IllegalArgumentException("Key cannot be the same as another one!");
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
}
