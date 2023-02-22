package org.example.stack.reuse;

import org.example.list.ListInterface;
import org.example.list.MyLinkedList;
import org.example.stack.StackInterface;

public class ListStack<E> implements StackInterface<E> { // stack has a list
    // 필드
    private ListInterface<E> list;


    // 생성자
    public ListStack() {
        list = new MyLinkedList<>(); // 여기서 리스트 구현체 지정
    }


    // 매서드
    @Override
    public void push(E newItem) {
        list.add(0, newItem);
    }

    @Override
    public E pop() {
        if (list.isEmpty()) throw new IndexOutOfBoundsException();
        return list.remove(0);
    }

    @Override
    public E top() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void popAll() {
        list.clear();
    }
}
