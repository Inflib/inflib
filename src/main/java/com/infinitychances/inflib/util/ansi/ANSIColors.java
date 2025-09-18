package com.infinitychances.inflib.util.ansi;


public final class ANSIColors {
    private ANSIColors() {}
    
    public static final ANSIColor RESET = new ANSIColor(1);
    public static final ANSIColor BOLD = new ANSIColor(2);
    public static final ANSIColor ITALICIZE = new ANSIColor(3);
    public static final ANSIColor UNDERLINE = new ANSIColor(4);
    
    public static final ANSIColor RED_TEXT = new ANSIColor(255, 18, 7, false);
    public static final ANSIColor RED_BACKGROUND = new ANSIColor(255, 18, 7, true);
    public static final ANSIColor RED_BOLD = RED_TEXT.join(BOLD);

    public static final ANSIColor ORANGE_TEXT = new ANSIColor(255, 140, 18, false);
    public static final ANSIColor ORANGE_BACKGROUND = new ANSIColor(255, 140, 18, true);
    public static final ANSIColor ORANGE_BOLD = ORANGE_TEXT.join(BOLD);
    
    public static final ANSIColor YELLOW_TEXT = new ANSIColor(255, 239, 18, false);
    public static final ANSIColor YELLOW_BACKGROUND = new ANSIColor(255, 239, 18, true);
    public static final ANSIColor YELLOW_BOLD = YELLOW_TEXT.join(BOLD);
    
    public static final ANSIColor GREEN_TEXT = new ANSIColor(44, 230, 50, false);
    public static final ANSIColor GREEN_BACKGROUND = new ANSIColor(44, 230, 50, true);
    public static final ANSIColor GREEN_BOLD = GREEN_TEXT.join(BOLD);
    
    public static final ANSIColor DARK_GREEN_TEXT = new ANSIColor(35, 138, 32, false);
    public static final ANSIColor DARK_GREEN_BACKGROUND = new ANSIColor(35, 138, 32, true);
    public static final ANSIColor DARK_GREEN_BOLD = DARK_GREEN_TEXT.join(BOLD);
    
    public static final ANSIColor CYAN_TEXT = new ANSIColor(42, 247, 247, false);
    public static final ANSIColor CYAN_BACKGROUND = new ANSIColor(42, 247, 247, true );
    public static final ANSIColor CYAN_BOLD = CYAN_TEXT.addBold();
    
    public static final ANSIColor BLUE_TEXT = new ANSIColor(34, 37, 201, false);
    public static final ANSIColor BLUE_BACKGROUND = new ANSIColor(34, 37, 201, true);
    public static final ANSIColor BLUE_BOLD = BLUE_TEXT.addBold();
    
    public static final ANSIColor PURPLE_TEXT = new ANSIColor(152, 34, 191, false);
    public static final ANSIColor PURPLE_BACKGROUND = new ANSIColor(152, 34, 191, true);
    public static final ANSIColor PURPLE_BOLD = PURPLE_TEXT.addBold();
    
    public static final ANSIColor WHITE_TEXT = new ANSIColor(255, 255, 255, false);
    public static final ANSIColor WHITE_BACKGROUND = new ANSIColor(255, 255, 255, true);
    public static final ANSIColor WHITE_BOLD = WHITE_TEXT.addBold();
    
    public static final ANSIColor BLACK_TEXT = new ANSIColor(0,0,0,false);
    public static final ANSIColor BLACK_BACKGROUND = new ANSIColor(0,0,0,true);
    public static final ANSIColor BLACK_BOLD = BLACK_TEXT.addBold();
    
    public static final ANSIColor ERROR = WHITE_BOLD.join(RED_BACKGROUND);
    public static final ANSIColor WARN = WHITE_BOLD.join(ORANGE_BACKGROUND);
    public static final ANSIColor INFO = WHITE_BOLD.join(new ANSIColor(45, 160, 41, true));
    
    public static final ANSIColor ALT_ERROR = RED_BOLD;
    public static final ANSIColor ALT_WARN = ORANGE_BOLD;
    public static final ANSIColor ALT_INFO = new ANSIColor(45, 160, 41).addBold(); //addAnsiText(45, 160, 41, "infoGreen") + BOLD
    
}
