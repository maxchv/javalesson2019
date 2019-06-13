package org.itstep.task01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.*;
import java.util.Random;
import java.util.stream.Stream;

class TestTask01 {

    @Test
    @Order(1)
    @DisplayName("Проверка наличия класса Human")
    void classHumanExists() throws ClassNotFoundException {
        Class.forName("org.itstep.task01.Human");
    }

    @Order(2)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка закрытого поля")
    @ValueSource(strings = {"fullName", "dateOfBirth", "phone", "city", "country", "address"})
    void fieldExists(String fieldName) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> cls = Class.forName("org.itstep.task01.Human");
        Field fullName = cls.getDeclaredField(fieldName);
        Assertions.assertTrue(Modifier.isPrivate(fullName.getModifiers()));
    }

    @Order(2)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка геттеров")
    @ValueSource(strings = {"getFullName", "getDateOfBirth", "getPhone", "getCity", "getCountry", "getAddress"})
    void getterExists(String getterName) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cls = Class.forName("org.itstep.task01.Human");
        Method declaredMethod = cls.getDeclaredMethod(getterName);
        Assertions.assertTrue(Modifier.isPublic(declaredMethod.getModifiers()));
    }

    @Order(3)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка сеттеров")
    @ValueSource(strings = {"setFullName", "setDateOfBirth", "setPhone", "setCity", "setCountry", "setAddress"})
    void setterExists(String setterName) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> cls = Class.forName("org.itstep.task01.Human");
        Method declaredMethod = cls.getDeclaredMethod(setterName, String.class);
        Assertions.assertTrue(Modifier.isPublic(declaredMethod.getModifiers()));
    }

    @Order(4)
    @ParameterizedTest(name = "{0}")
    @DisplayName("Проверка сеттеров/геттеров")
    @ValueSource(strings = {"fullName", "dateOfBirth", "phone", "city", "country", "address"})
    void setterGetter(String fieldName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName("org.itstep.task01.Human");
        Object human = cls.getDeclaredConstructor().newInstance();
        String setterName = String.format("set%c%s", Character.toUpperCase(fieldName.charAt(0)), fieldName.substring(1));
        String getterName = String.format("get%c%s", Character.toUpperCase(fieldName.charAt(0)), fieldName.substring(1));
        Method setter = cls.getDeclaredMethod(setterName, String.class);
        Method getter = cls.getDeclaredMethod(getterName);
        String expected = randomString();
        setter.invoke(human, expected);
        Object actual = getter.invoke(human);
        Assertions.assertEquals(expected, actual);
    }

    @Order(5)
    @Test
    @DisplayName("Проверка Конструкторов")
    void constructors() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> cls = Class.forName("org.itstep.task01.Human");
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        Assertions.assertEquals(2, declaredConstructors.length);

        Class<String> str = String.class;
        Constructor<?> ctor = cls.getDeclaredConstructor(str, str, str, str, str, str);

        String fullName = randomString();
        String dateOfBirth = randomString();
        String phone = randomString();
        String city = randomString();
        String country = randomString();
        String address = randomString();

        Object human = ctor.newInstance(fullName, dateOfBirth, phone, city, country, address);

        Method getFullName = cls.getDeclaredMethod("getFullName");
        Assertions.assertEquals(fullName, getFullName.invoke(human));

        Method getDateOfBirth = cls.getDeclaredMethod("getDateOfBirth");
        Assertions.assertEquals(dateOfBirth, getDateOfBirth.invoke(human));

        Method getPhone = cls.getDeclaredMethod("getPhone");
        Assertions.assertEquals(phone, getPhone.invoke(human));

        Method getCity = cls.getDeclaredMethod("getCity");
        Assertions.assertEquals(city, getCity.invoke(human));

        Method getCountry = cls.getDeclaredMethod("getCountry");
        Assertions.assertEquals(country, getCountry.invoke(human));

        Method getAddress = cls.getDeclaredMethod("getAddress");
        Assertions.assertEquals(address, getAddress.invoke(human));
    }


    static Random rnd = new Random();

    static String randomString() {
        return Stream.generate(() -> rnd.nextInt('z' - 'a' + 1) + 'a')
                .limit(rnd.nextInt(20) + 20)
                .map(Object::toString)
                .reduce(String::concat).orElse("");
    }
}
