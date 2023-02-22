package org.example.stack.reuse;

import org.example.list.MyLinkedList;
import org.example.stack.StackInterface;

public class InheritedStack<E> extends MyLinkedList<E> implements StackInterface<E> { // stack is a linked list
    // 필드
    // topNode : head 로 고려하면 되나?

    // 생성자
    public InheritedStack() {
        super();
    }

    // 매서드
    @Override
    public void push(E newItem) {
        add(0, newItem); // top (= head) 에 올린 것이기 때문
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return remove(0);
    }

    @Override
    public E top() {
        return get(0);
    }

    @Override
    public void popAll() {
        clear();
    }
}
