package com.infinitychances.inflib.util.block;

class MapKey {
    private String key;
    private int count;

    public MapKey(String key, int count) {
        this.key = key;
        this.count = count;
    }

    public static MapKey of(String key, int count) {
        return new MapKey(key, count);
    }

    public String getKey() {
        return this.key;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public String toString() {
        return key + TrailMap.SPLIT_CHAR + count;
    }
}
