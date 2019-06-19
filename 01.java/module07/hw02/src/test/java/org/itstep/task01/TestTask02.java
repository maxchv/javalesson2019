package org.itstep.task01;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.*;
import java.util.Random;
import java.util.stream.Stream;

class TestTask02 {

    private final String className = "org.itstep.task02.City";

    @Test
    @Order(1)
    @DisplayName("Проверка наличия класса City")
    void classExists() throws ClassNotFoundException {
        Class.forName(className);
    }

    @Order(2)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка закрытых полей")
    @ValueSource(strings = {"name", "region", "country", "inhabitants", "index", "code"})
    void privateFieldExists(String fieldName) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> cls = Class.forName(className);
        Field fullName = cls.getDeclaredField(fieldName);
        Assertions.assertTrue(Modifier.isPrivate(fullName.getModifiers()));
    }

    @Order(2)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка геттеров")
    @ValueSource(strings = {"getName", "getRegion", "getCountry", "getInhabitants", "getIndex", "getCode"})
    void publicGetterExists(String getterName) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cls = Class.forName(className);
        Method declaredMethod = cls.getDeclaredMethod(getterName);
        Assertions.assertTrue(Modifier.isPublic(declaredMethod.getModifiers()));
    }

    @Order(3)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка сеттеров")
    @ValueSource(strings = {"setName", "setRegion", "setCountry", "setInhabitants", "setIndex", "setCode"})
    void publicSetterExists(String setterName) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cls = Class.forName(className);
        if ("setInhabitants".equals(setterName)) {
            Method declaredMethod = cls.getDeclaredMethod(setterName, int.class);
            Assertions.assertTrue(Modifier.isPublic(declaredMethod.getModifiers()));
        } else {
            Method declaredMethod = cls.getDeclaredMethod(setterName, String.class);
            Assertions.assertTrue(Modifier.isPublic(declaredMethod.getModifiers()));
        }
    }

    @Order(4)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка сеттеров/геттеров")
    @ValueSource(strings = {"name", "region", "country", "inhabitants", "index", "code"})
    void setterGetterWork(String fieldName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName(className);
        Object human = cls.getDeclaredConstructor().newInstance();

        String setterName = String.format("set%c%s", Character.toUpperCase(fieldName.charAt(0)), fieldName.substring(1));
        String getterName = String.format("get%c%s", Character.toUpperCase(fieldName.charAt(0)), fieldName.substring(1));


        if ("inhabitants".equals(fieldName)) {
            Method setter = cls.getDeclaredMethod(setterName, int.class);
            Method getter = cls.getDeclaredMethod(getterName);
            int expected = rnd.nextInt(8_000_000);
            setter.invoke(human, expected);
            Object actual = getter.invoke(human);
            Assertions.assertEquals(expected, actual);
        } else {
            Method setter = cls.getDeclaredMethod(setterName, String.class);
            Method getter = cls.getDeclaredMethod(getterName);
            String expected = randomString();
            setter.invoke(human, expected);
            Object actual = getter.invoke(human);
            Assertions.assertEquals(expected, actual);
        }
    }

    @Order(5)
    @Test
    @DisplayName("Проверка Конструкторов")
    void constructors() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName(className);
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Assertions.assertEquals(2, declaredConstructors.length);

        Class<String> stringClass = String.class;
        Class<Integer> integerClass = int.class;
        Constructor<?> ctor = cls.getDeclaredConstructor(stringClass, stringClass, stringClass, integerClass, stringClass, stringClass);

        String name = randomString();
        String region = randomString();
        String country = randomString();
        int inhabitants = rnd.nextInt(8_000_000);
        String index = randomString();
        String code = randomString();

        Object human = ctor.newInstance(name, region, country, inhabitants, index, code);

        Method getName = cls.getDeclaredMethod("getName");
        Assertions.assertEquals(name, getName.invoke(human));

        Method getRegion = cls.getDeclaredMethod("getRegion");
        Assertions.assertEquals(region, getRegion.invoke(human));

        Method getCountry = cls.getDeclaredMethod("getCountry");
        Assertions.assertEquals(country, getCountry.invoke(human));

        Method getInhabitants = cls.getDeclaredMethod("getInhabitants");
        Object invoke = getInhabitants.invoke(human);
        Assertions.assertEquals(inhabitants, invoke);

        Method getIndex = cls.getDeclaredMethod("getIndex");
        Assertions.assertEquals(index, getIndex.invoke(human));

        Method getCode = cls.getDeclaredMethod("getCode");
        Assertions.assertEquals(code, getCode.invoke(human));
    }


    static Random rnd = new Random();

    static String randomString() {
        return Stream.generate(() -> rnd.nextInt('z' - 'a' + 1) + 'a')
                .limit(rnd.nextInt(20) + 20)
                .map(i -> (char) i.intValue())
                .map(s -> new String(new char[]{s}))
                .reduce(String::concat).orElse("");
    }
}
