package com.infinitychances.inflib.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ReservedStuffManager {
    private ReservedStuffManager() {}

    public static final String SPLIT_CHAR = "≈";

    private static final String[] RESERVED_CHARACTERS = {"≈"/*247*/, "∞"/*236*/, "»"/*175*/, "«"/*174*/, "•"/*7*/};
    private static final Map<String, Integer> ALT_CODES_START = Map.of(
            "≈", 247,
            "∞", 236,
            "»", 175,
            "«", 174,
            "•", 7
    );
    private static final HashMap<String, Integer> ALT_CODES = new HashMap<>(ALT_CODES_START);
    private static final ArrayList<String> TEMP_RESERVED = new ArrayList<>();
    private static final String[] NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

    public static boolean isReserved(String string) {
        boolean b = false;
        for(String str : RESERVED_CHARACTERS) {
            b = string.contains(str);
            if(b) {break;}
        }
        for(String str : TEMP_RESERVED) {
            b = string.contains(str);
            if(b) {break;}
        }
        return b;
    }

    public static boolean isReserved(String string, Boolean runExtraList) {
        boolean b = false;
        for(String str : RESERVED_CHARACTERS) {
            b = string.contains(str);
            if(b) {break;}
        }
        if(!runExtraList) {
            return b;
        }
        for(String str : TEMP_RESERVED) {
            b = string.contains(str);
            if(b) {break;}
        }
        return b;
    }

    public static boolean hasNumber(String string) {
        boolean b = false;
        for(String str : NUMBERS) {
            b = string.contains(str);
            if(b) {break;}
        }
        return b;
    }

    private static boolean hasAlphaChar(String string) {
        boolean b = false;
        for(String str : LETTERS) {
            b = string.contains(str);
            if(b) {break;}
        }
        return b;
    }

    private static boolean hasAlphaNumeric(String string) {
        return hasAlphaChar(string) || hasNumber(string);
    }

    public static String[] requestReservedList() {
        return RESERVED_CHARACTERS;
    }

    @Deprecated(since = "0.4.0")
    public static Integer getAltCodeOfCharacter(String character) {
        return ALT_CODES.get(character);
    }

    @Deprecated(since = "0.4.0")
    public static Integer getAltCodeOfCharacter(Character character) {
        return getAltCodeOfCharacter(character.toString());
    }

    public static void addReservedCharacter(Character character) {
        if(hasAlphaNumeric(character.toString())) {
            throw new IllegalArgumentException("character cannot be a letter or a number!");
        }
        TEMP_RESERVED.add(character.toString());
    }

    public static String[] requestExtraReservedList() {
        String[] array = new String[TEMP_RESERVED.size()];
        return TEMP_RESERVED.toArray(array);
    }
}