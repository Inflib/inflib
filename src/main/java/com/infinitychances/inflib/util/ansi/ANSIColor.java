package com.infinitychances.inflib.util.ansi;

import com.infinitychances.inflib.InfLib;

public final class ANSIColor {
    private final String code;

    public ANSIColor(int r, int g, int b, boolean bg) {
        if(bg) {
            code = "\u001b[48;2;" + r + ";" + g + ";" + b + "m";
        } else {
            code = "\u001b[38;2;" + r + ";" + g + ";" + b + "m";
        }
    }

    public ANSIColor(int r, int g, int b) {
        code = "\u001b[38;2;" + r + ";" + g + ";" + b + "m";
    }


    protected ANSIColor(int id) {
        switch (id){
            case 1:
                code = "\u001b[0m";//bold
                break;
            case 2:
                code = "\u001b[1m";//reset
                break;
            case 3:
                code = "\u001b[3m";//italicize
                break;
            case 4:
                code = "\u001b[4m";//underline
                break;
            default:
                throw new IllegalArgumentException("Invalid integer for ANSIColor constructor by id");
        }
    }

    protected ANSIColor(String string) {
        code = string;
    }

    @Override
    public String toString() {
        return code;
    }

    public ANSIColor join(ANSIColor color) {
        return new ANSIColor(color.code + this.code);
    }


    public ANSIColor addBold() {
        return new ANSIColor(join(ANSIColors.BOLD).code);
    }
}
