package org.example.stack;

public interface StackInterface<E> {

    // 주요 기능들 3가지
    public void push(E newItem);
    public E pop();
    public E top();

    public boolean isEmpty();
    public void popAll();
}
