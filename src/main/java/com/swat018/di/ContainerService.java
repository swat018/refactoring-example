package com.swat018.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType){
        T instance =  createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f-> {
            if (f.getAnnotation(Inject.class) != null) {
               Object fieldInstnace = createInstance(f.getType());
               f.setAccessible(true);
                try {
                    f.set(instance, fieldInstnace);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
           throw new RuntimeException(e);
        }
    }
}
