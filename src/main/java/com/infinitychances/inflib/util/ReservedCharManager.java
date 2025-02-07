package com.infinitychances.inflib.util;

public class ReservedCharManager {
    private ReservedCharManager() {

    }

    private static final String[] RESERVED_CHARACTERS = {"≈"/*247*/, "∞"/*236*/, "»"/*175*/, "•"/*7*/};

    public static boolean isReserved(String string) {
        boolean b = false;
        for(String str : RESERVED_CHARACTERS) {
            b = string.contains(str);
            if(b) {break;}
        }
        return b;
    }

    public static boolean hasNumber(String string) {
        boolean b = false;
        for(String str : new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}) {
            b = string.contains(str);
            if(b) {break;}
        }
        return b;
    }

    public static String[] requestReservedList() {
        return RESERVED_CHARACTERS;
    }
}
