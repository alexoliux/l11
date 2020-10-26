package zadanie1;

import java.util.Arrays;

public class ArrayQueueModule
{
    private static int size;
    private static int head;
    private static int tail;
    private static Object[] elements;
    private static ArrayQueueModule arr;

    private ArrayQueueModule() {
        elements = new Object[8];
        size = 0;
        head = 0;
        tail = 0;
    }

    private static void resize(int capacity)
    {
        int len = elements.length;
        if (capacity > len)
        {
            Object[] newElements = new Object[len * 2];
            System.arraycopy(elements, 0, newElements, 0, len);
            elements = newElements;
        }
    }

    //pre: element != null
    //post: elements[tail] = element,
    //      tail = (tail + 1) % elements.length,
    //      size = size + 1
    public static void enqueue(Object element)
    {
        if (arr == null) arr = new ArrayQueueModule();
        assert element != null;
        resize(size + 1);
        size++;
        if (size != 1) tail = (tail + 1) % elements.length;
        elements[tail] = element;
    }

    //pre: size > 0
    //post: R = elements[head]
    public static Object element()
    {
        assert size > 0;
        return elements[head];
    }

    //pre: size > 0
    //post: R = elements[head],
    //      head = (head + 1) % elements.length,
    //      size = size - 1
    public static Object dequeue()
    {
        assert size > 0;
        Object ret = element();
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        if (size == 0) {
            head = tail = 0;
        }
        return ret;
    }

    //post: R = size
    public static int size()
    {
        return size;
    }

    //post: R = (size == 0)
    public static boolean isEmpty()
    {
        return (size == 0);
    }

    //post: size = 0,
    //      head = 0,
    //      tail = 0
    public static void clear() {
        head = 0;
        tail = 0;
        size = 0;
        elements = new Object[8];
    }

    public static String print() {
        return "elements: " + Arrays.toString(elements) + "\ntail: " + tail + "\nsize: " + size + "\nhead: " + head;
    }

}