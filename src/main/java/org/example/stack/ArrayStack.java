package org.example.stack;

public class ArrayStack<E> implements StackInterface<E> {

    // 필드
    private E[] stack;
    private int topIndex;

    private static final int DEFAULT_CAPACITY = 64;


    // 생성자
    public ArrayStack() {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1;
    }

    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        topIndex = -1;
    }


    // 매서드
    @Override
    public void push(E newItem) {
        if (isFull()) throw new IndexOutOfBoundsException();
        stack[++topIndex] = newItem;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return stack[topIndex--]; // 배열에서 원소 제거는 하지 않고, 인덱스만 조절한다
    }

    @Override
    public E top() {
        if (isEmpty()) throw new ArrayIndexOutOfBoundsException();
        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return (topIndex == -1);
    }

    @Override
    public void popAll() {
        topIndex = -1;
        stack = (E[]) new Object[DEFAULT_CAPACITY];
    }

    private boolean isFull() {
        return (topIndex == stack.length - 1);
    }
}
