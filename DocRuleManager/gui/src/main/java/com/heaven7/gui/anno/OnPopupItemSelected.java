package com.heaven7.gui.anno;

import java.lang.annotation.*;

/**
 * current used for popup-item select
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnPopupItemSelected {

    /**
     * the item name
     * @return the item name
     */
    String value();
}
