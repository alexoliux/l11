package zadanie1;

import java.util.Arrays;

public class ArrayQueue {
    private int size;
    private int head;
    private int tail;
    private Object[] elements;

    public ArrayQueue() {
        size = tail = head = 0;
        elements = new Object[8];
    }

    private void resize(int capacity) {
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
    public void enqueue(Object element)
    {
        assert element != null;
        resize(size + 1);
        size++;
        if (size != 1) tail = (tail + 1) % elements.length;
        elements[tail] = element;

    }

    //pre: size > 0
    //post: R = elements[head]
    public Object element() {
        assert size > 0;
        return elements[head];
    }

    //pre: size > 0
    //post: R = elements[head],
    //      head = (head + 1) % elements.length,
    //      size = size - 1
    public Object dequeue() {
        assert size > 0;
        Object ret = element();
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        if (size == 0) head = tail = 0;
        return ret;
    }

    //post: R = size
    public int size()
    {
        return size;
    }

    //post: R = (size == 0)
    public boolean isEmpty()
    {
        return (size == 0);
    }

    //size = tail = head = 0;
    //elements = new Object[8];
    public void clear() {
        size = tail = head = 0;
        elements = new Object[8];
    }

    @Override
    public String toString() {
        return "elements: " + Arrays.toString(elements) + "\ntail: " + tail + "\nsize: " + size + "\nhead: " + head;
    }
}