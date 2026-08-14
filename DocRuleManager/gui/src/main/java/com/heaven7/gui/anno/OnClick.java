package com.heaven7.gui.anno;

import java.lang.annotation.*;

/**
 * current used for button/textView
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnClick {

    /**
     * the id of view
     * @return the view id
     */
    String value();
}
