package ua.step.examples.util.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinaryTest
{
    @Test
    public void testZero()
    {
        byte value = 0;
        assertEquals("error", "00000000", Binary.toBinary(Byte.SIZE, value));
        short value1 = 0;
        assertEquals("error", "0000000000000000", Binary.toBinary(Short.SIZE, value1));
        int value2 = 0;
        assertEquals("error", "00000000000000000000000000000000", Binary.toBinary(Integer.SIZE, value2));
        long value3 = 0;
        assertEquals("error", "0000000000000000000000000000000000000000000000000000000000000000",
                Binary.toBinary(Long.SIZE, value3));
    }

    @Test
    public void testOne()
    {
        byte value = 1;
        assertEquals("error", "00000001", Binary.toBinary(Byte.SIZE, value));
        short value1 = 1;
        assertEquals("error", "0000000000000001", Binary.toBinary(Short.SIZE, value1));
        int value2 = 1;
        assertEquals("error", "00000000000000000000000000000001", Binary.toBinary(Integer.SIZE, value2));
        long value3 = 1;
        assertEquals("error", "0000000000000000000000000000000000000000000000000000000000000001",
                Binary.toBinary(Long.SIZE, value3));
    }

    @Test
    public void testNegativeOne()
    {
        byte value = -1;
        assertEquals("error", "11111111", Binary.toBinary(Byte.SIZE, value));
        short value1 = -1;
        assertEquals("error", "1111111111111111", Binary.toBinary(Short.SIZE, value1));
        int value2 = -1;
        assertEquals("error", "11111111111111111111111111111111", Binary.toBinary(Integer.SIZE, value2));
        long value3 = -1;
        assertEquals("error", "1111111111111111111111111111111111111111111111111111111111111111",
                Binary.toBinary(Long.SIZE, value3));
    }

    @Test
    public void testMax()
    {
        byte value = Byte.MAX_VALUE;
        assertEquals("error", "01111111", Binary.toBinary(Byte.SIZE, value));
        short value1 = Short.MAX_VALUE;
        assertEquals("error", "0111111111111111", Binary.toBinary(Short.SIZE, value1));
        int value2 = Integer.MAX_VALUE;
        assertEquals("error", "01111111111111111111111111111111", Binary.toBinary(Integer.SIZE, value2));
        long value3 = Long.MAX_VALUE;
        assertEquals("error", "0111111111111111111111111111111111111111111111111111111111111111",
                Binary.toBinary(Long.SIZE, value3));
    }

    @Test
    public void testMin()
    {
        byte value = Byte.MIN_VALUE;
        assertEquals("error", "10000000", Binary.toBinary(Byte.SIZE, value));
        short value1 = Short.MIN_VALUE;
        assertEquals("error", "1000000000000000", Binary.toBinary(Short.SIZE, value1));
        int value2 = Integer.MIN_VALUE;
        assertEquals("error", "10000000000000000000000000000000", Binary.toBinary(Integer.SIZE, value2));
        long value3 = Long.MIN_VALUE;
        assertEquals("error", "1000000000000000000000000000000000000000000000000000000000000000",
                Binary.toBinary(Long.SIZE, value3));
    }
}