package org.example.list;

public class MyArrayList<E> implements ListInterface<E> {

    // 필드
    private E[] items;
    private int size;
    private static final int DEFAULT_CAPACITY = 64;


    // 생성자
    public MyArrayList() {
        items = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        items = (E[]) new Object[initialCapacity];
        size = 0;
    }


    // 매서드
    @Override
    public void add(int index, E element) {
        if (index >= items.length || index < 0 || index > size) throw new IndexOutOfBoundsException();

        for (int i = size - 1; i >= index; i--) items[i + 1] = items[i];
        items[index] = element;
        size++;
    }

    @Override
    public void append(E element) {
        if (items.length <= size) throw new IndexOutOfBoundsException();
        items[size] = element;
        size++;
    }


    @Override
    public E get(int index) {
        if (index < size || index >= 0) return items[index];
        else throw new IndexOutOfBoundsException();
    }

    private final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (items[i] == element) return i; // compare 을 따로 구현해줘야 함
        }
        return NOT_FOUND;
    }

    @Override
    public void set(int index, E element) {
        if (index < size || index >= 0) items[index] = element;
        else throw new IndexOutOfBoundsException();
    }

    @Override
    public E remove(int index) {
        if (isEmpty() || index < 0 || index > size - 1) throw new IndexOutOfBoundsException();

        E old = get(index);
        for (int i = index + 1; i <= size - 1; i++) items[i - 1] = items[i];
        size--;
        return old;
    }

    @Override
    public boolean removeItem(E element) {
        for (int i = 0; i < size - 1; i++) {
            if (items[i] == element) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int len() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        items = (E[]) new Object[items.length];
        size = 0;
    }
}
