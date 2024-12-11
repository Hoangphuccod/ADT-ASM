import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] elements;
    private int size = 0;

    public MyStack() {
        elements = (T[]) new Object[10];
    }

    public void push(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = elements[--size];
        elements[size] = null;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    private void resize() {
        T[] newElements = (T[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }
}
