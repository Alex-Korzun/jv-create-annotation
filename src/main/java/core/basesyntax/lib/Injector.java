package core.basesyntax.lib;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.GamblerDao;
import core.basesyntax.exception.NoSuchAnnotationException;
import core.basesyntax.factory.Factory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Injector {
    public static Object getInstance(Class clazz) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Object instance = declaredConstructor.newInstance();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(Inject.class) != null) {
                field.setAccessible(true);
                if (field.getType().equals(BetDao.class)) {
                    field.set(instance, Factory.getBetDao());
                } else if (field.getType().equals(GamblerDao.class)) {
                    field.set(instance, Factory.getGamblerDao());
                } else {
                    throw new NoSuchAnnotationException("There is no such annotation!");
                }
            }
        }
        return instance;
    }
}

