package com.jay.java.DynamicCompiler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE, ElementType.FIELD})
public @interface Author {
	String value();
}
