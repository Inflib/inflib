package com.infinitychances.inflib.annotations;

import java.lang.annotation.*;

/**
 * A class with {@code VersionResistant} means that the class does not need to be changed with
 * each following mc version.
 * @author InfinityChances
 * @since 0.4.1
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VersionResistant {
}
