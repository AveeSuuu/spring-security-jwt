package dev.avee.bettersecurity.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectUtils {

    public static <T> T cast(Object object, Class<T> clazz) {
        return clazz.cast(object);
    }
}