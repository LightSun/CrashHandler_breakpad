package com.heaven7.gui.anno;

import java.lang.annotation.*;

/**
 * current used for Select-File
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnSelected {

    /**
     * the item name
     * @return the item name
     */
    String value();
}
