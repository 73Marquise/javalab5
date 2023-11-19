package org.example.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    final static String FILE_PATH = "src/main/resources/config.properties";

    /**
     * takes an object of any type, looks for fields annotated with the AutoInjectable annotation,
     * finds out from the properties file how to initialize these fields and initializes them
     * @param object object whose fields should be initialized
     * @return object with initialized fields
     * @param <T> T represents any data type
     */
    public <T> T inject(T object) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(FILE_PATH));
            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutoInjectable.class)) {
                    if (field.getType().isInterface()) {
                        String implementationClassName = properties.getProperty(field.getType().getName());
                        Class<?> implementationClass = Class.forName(implementationClassName);
                        Object implementationObject = implementationClass.getDeclaredConstructor().newInstance();
                        field.setAccessible(true);
                        field.set(object, implementationObject);
                    }
                }
            }
        } catch (IOException | ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return object;
    }
}
