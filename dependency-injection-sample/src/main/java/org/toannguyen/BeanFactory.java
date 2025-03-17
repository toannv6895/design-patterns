package org.toannguyen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public enum BeanFactory {
    INSTANCE {
        private final ConcurrentHashMap<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

        @Override
        public <T> T getInstanceOf(Class<T> clazz, Object... args) {
            try {
                if (clazz.isAnnotationPresent(Singleton.class)) {
                    if (beanMap.containsKey(clazz)) {
                        return (T) beanMap.get(clazz);
                    }

                    T bean = super.instantiateBeanClass(clazz, args);
                    beanMap.put(clazz, bean);
                    return bean;
                }
                else {
                    return super.instantiateBeanClass(clazz, args);
                }

            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    };

    private <T> T instantiateBeanClass(Class<T> clazz, Object[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?>[] argsClasses = Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
        Constructor<T> constructor = clazz.getConstructor(argsClasses);
        T bean = constructor.newInstance(args);

        // Create all properties have @inject annotation
        Field[] fields = clazz.getDeclaredFields();
        Field[] injectableFields = Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(Inject.class))
                .toArray(Field[]::new);

        for (Field field : injectableFields) {
            Class<?> fieldType = field.getType();
            Object fieldValue = BeanFactory.INSTANCE.getInstanceOf(fieldType);
            // need to set accessible before set value with private/protected field
            field.setAccessible(true);
            field.set(bean, fieldValue);
        }

        return bean;
    }

    public abstract <T> T getInstanceOf(Class<T> clazz, Object... args);
}
