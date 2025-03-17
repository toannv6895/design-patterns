package org.toannguyen;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public enum BeanFactory {
    INSTANCE {
        @Override
        public <T> T getInstanceOf(Class<T> clazz, Object... args) {
            try {
                Class<?>[] argsClasses = Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
                Constructor<T> constructor = clazz.getConstructor(argsClasses);
                return constructor.newInstance(args);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    };

    public abstract <T> T getInstanceOf(Class<T> clazz, Object... args);
}
