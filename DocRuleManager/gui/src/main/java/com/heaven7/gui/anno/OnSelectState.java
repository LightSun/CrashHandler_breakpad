package com.heaven7.gui.anno;

import java.lang.annotation.*;

/**
 * current used for PullDownBox
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnSelectState {

    /**
     * the item name
     * @return the item name
     */
    String value();
}
