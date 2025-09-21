package com.infinitychances.inflib.util.map;

import com.infinitychances.inflib.InfLib;
import com.infinitychances.inflib.annotations.MayReturnNull;

import java.util.Random;

/**
 * A version of a trailmap that only holds one key.
 * @param <V> The type of trailmap to be used
 * @since 0.4.2
 */
public class SingleTrailMap<V> {
    private String key;
    private TrailMap<V> trailMap = new TrailMap<>();
    private String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public SingleTrailMap() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            builder.append(letters.charAt(random.nextInt(letters.length())));
        }
        construct(builder.toString());
    }
    public SingleTrailMap(String key) {
        construct(key);
    }

    private void construct(String key) {
        this.key = key;
        InfLib.LOGGER.info(key);
    }

    @SafeVarargs
    public final SingleTrailMap<V> map(V... values) {
        trailMap.map(key, values);
        return this;
    }

    @SafeVarargs
    public final void insertAtBeginning(V... values) {
        trailMap.insertAtBeginning(key, values);
    }

    public final void insertAtIndex(Integer index, V value) {
        trailMap.insertAtIndex(key, index, value);
    }

    @SafeVarargs
    public final void insertAtIndex(Integer index, V... values) {
        trailMap.insertAtIndex(key, index, values);
    }

    @SafeVarargs
    public final void insertAtEnd(V... values) {
        trailMap.insertAtEnd(key, values);
    }

    @MayReturnNull
    public V getNextFromId(Integer id) {
        return trailMap.getNextFromId(key, id);
    }

    @MayReturnNull
    public V getPreviousFromId(Integer id) {
        return trailMap.getPreviousFromId(key, id);
    }

    @MayReturnNull
    public V getFromId(Integer id) {
        return trailMap.getFromId(key, id);
    }

    @MayReturnNull
    public V getNext(V value) {
        return trailMap.getNext(key, value);
    }

    @MayReturnNull
    public V getPrevious(V value) {
        return trailMap.getPrevious(key, value);
    }

    protected String getKey() {
        return key;
    }
    protected void setKey(String newKey) {
        key = newKey;
    }

    protected TrailMap<V> getTrailMap() {
        return trailMap;
    }
}
