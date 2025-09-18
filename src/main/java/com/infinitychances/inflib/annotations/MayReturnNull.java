package com.infinitychances.inflib.annotations;


import java.lang.annotation.*;

/**
 * A method with {@code MayReturnNull} states that null is a value that could show up, either from user error,
 * or intentional doing. Because of this, users of a method annotated with {@code MayReturnNull} should
 * check against null values.
 * @author InfinityChances
 **/
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD})
public @interface MayReturnNull {
}
