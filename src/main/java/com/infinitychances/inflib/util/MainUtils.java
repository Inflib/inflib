package com.infinitychances.inflib.util;

import com.infinitychances.inflib.InfLib;

public final class MainUtils {
    private MainUtils() {
    
    }
    
    public static <S> void print(S methodResult) {
        InfLib.LOGGER.info(methodResult.toString());
    }
}
