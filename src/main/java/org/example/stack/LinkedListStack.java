package org.example.stack;

import org.example.list.node.Node;

public class LinkedListStack<E> implements StackInterface<E> {
    // 필드
    private Node<E> topNode;

    // 생성자
    public LinkedListStack() {
        topNode = null;
    }

    // 매서드
    @Override
    public void push(E newItem) { // 배열기반처럼 정적 공간을 미리 고려하지 않아도 된다!
        topNode = new Node<>(newItem, topNode);
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        Node<E> temp = topNode;
        topNode = topNode.next;
        return temp.item;
    }

    @Override
    public E top() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return topNode.item;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void popAll() {
        topNode = null;
    }
    // 특징
    // 1. 아래 방향으로 흐르는 node 이다! 따라서 top 은 head
}
