package com.infinitychances.inflib.util;

import java.util.HashMap;

public final class ANSIColors {
    private ANSIColors() {}
    
    private static final HashMap <String, String> backgrounds = new HashMap<>();
    private static final HashMap <String, String> texts = new HashMap<>();
    
    public static HashMap<String, String> getTexts() {
        return texts;
    }
    
    public static HashMap<String, String> getBackgrounds() {
        return backgrounds;
    }
    
    public static String getAnsiBackground(String name) {
        return backgrounds.get(name);
    }
    
    public static String getAnsiText(String name) {
        return texts.get(name);
    }
    
    public static String addAnsiBackground(int r, int g, int b) {
        return "\u001b[48;2;" + r + ";" + g + ";" + b + "m";
    }
    
    public static String addAnsiBackground(int r, int g, int b, String name) {
        String result = addAnsiBackground(r, g, b);
        backgrounds.put(name, result);
        return result;
    }
    
    public static String addAnsiText(int r, int g, int b) {
        return "\u001b[38;2;" + r + ";" + g + ";" + b + "m";
    }
    
    public static String addAnsiText(int r, int g, int b, String name) {
        String result = addAnsiText(r, g, b);
        texts.put(name, result);
        return result;
    }
    
    public static String addBoldText(int r, int g, int b) {
        return BOLD + addAnsiText(r, g, b);
    }
    
    //adds _bold
    public static String addBoldText(int r, int g, int b, String name) {
        String result = BOLD + addAnsiText(r, g, b);
        texts.put(name+"_bold" ,result);
        return result;
    }
    
    public static final String RESET = "\u001b[0m";
    public static final String BOLD = "\u001b[1m";
    public static final String ITALICIZE = "\u001b[3m";
    public static final String UNDERLINE = "\u001b[4m";
    
    public static final String RED_TEXT = "\u001b[38;2;255;18;77m";
    public static final String RED_BACKGROUND = "\u001b[48;2;255;18;77m";
    public static final String RED_BOLD = RED_TEXT + BOLD;
    
    public static final String ORANGE_TEXT = "\u001b[38;2;255;140;18m";
    public static final String ORANGE_BACKGROUND = "\u001b[48;2;255;140;18m";
    public static final String ORANGE_BOLD = ORANGE_TEXT + BOLD;
    
    public static final String YELLOW_TEXT = "\u001b[38;2;255;239;18m";
    public static final String YELLOW_BACKGROUND = "\u001b[48;2;255;239;18m";
    public static final String YELLOW_BOLD = YELLOW_TEXT + BOLD;
    
    public static final String GREEN_TEXT = "\u001b[38;2;44;230;50m";
    public static final String GREEN_BACKGROUND = "\u001b[48;2;44;230;50m";
    public static final String GREEN_BOLD = GREEN_TEXT + BOLD;
    
    public static final String DARK_GREEN_TEXT = "\u001b[38;2;35;138;32m";
    public static final String DARK_GREEN_BACKGROUND = "\u001b[48;2;35;138;32m";
    public static final String DARK_GREEN_BOLD = DARK_GREEN_TEXT + BOLD;
    
    public static final String CYAN_TEXT = "\u001b[38;2;42;247;247m";
    public static final String CYAN_BACKGROUND = "\u001b[48;2;42;247;247m";
    public static final String CYAN_BOLD = CYAN_TEXT + BOLD;
    
    public static final String BLUE_TEXT = "\u001b[38;2;34;37;201m";
    public static final String BLUE_BACKGROUND = "\u001b[48;2;34;37;201m";
    public static final String BLUE_BOLD = BLUE_TEXT + BOLD;
    
    public static final String PURPLE_TEXT = "\u001b[38;2;152;34;191m";
    public static final String PURPLE_BACKGROUND = "\u001b[48;2;152;34;191m";
    public static final String PURPLE_BOLD = PURPLE_TEXT + BOLD;
    
    public static final String WHITE_TEXT = "\u001b[38;2;255;255;255m";
    public static final String WHITE_BACKGROUND = "\u001b[48;2;255;255;255m";
    public static final String WHITE_BOLD = WHITE_TEXT + BOLD;
    
    public static final String BLACK_TEXT = "\u001b[38;2;0;0;0m";
    public static final String BLACK_BACKGROUND = "\u001b[48;2;0;0;0m";
    public static final String BLACK_BOLD = BLACK_TEXT + BOLD;
    
    public static final String ERROR = WHITE_BOLD + RED_BACKGROUND;
    public static final String WARN = WHITE_BOLD + ORANGE_BACKGROUND;
    public static final String INFO = WHITE_BOLD + addAnsiBackground(45, 160, 41, "infoGreen");
    
    public static final String ALT_ERROR = RED_BOLD;
    public static final String ALT_WARN = ORANGE_BOLD;
    public static final String ALT_INFO = addAnsiText(45, 160, 41, "infoGreen") + BOLD;
    
}
