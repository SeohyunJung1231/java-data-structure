package org.example.list;

import org.example.list.node.BidirectionalNode;

public class CircularDoublyLinkedList<E> implements ListInterface<E> {

    // 필드
    private BidirectionalNode<E> head;
    private int size;

    // 생성자
    public CircularDoublyLinkedList() {
        size = 0;
        head = new BidirectionalNode<>(null); // 더미헤드
        head.next = head;
        head.prev = head;
    }

    @Override
    public void add(int index, E element) {
        BidirectionalNode<E> previousNode = getNode(index - 1);
        BidirectionalNode<E> currentNode = new BidirectionalNode<>(element, previousNode, previousNode.next);
        previousNode.next = currentNode;
        currentNode.next.prev = currentNode;

        size++;
    }

    @Override
    public void append(E element) {
        BidirectionalNode<E> previousNode = head.prev;
        BidirectionalNode<E> currentNode = new BidirectionalNode<>(element, previousNode, head);
        previousNode.next = currentNode;
        head.prev = currentNode;

        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    private BidirectionalNode<E> getNode(int index) {
        if (index < -1 || index > size) throw new IndexOutOfBoundsException();
        BidirectionalNode<E> currentNode = head;
        // 인덱스를 반으로 나눠서, 속도를 높인다 (O(??))
        if (index <= size / 2) {
            for (int i = 0; i <= index; i++) currentNode = currentNode.next;
        } else {
            for (int i = size - 1; i >= index; i--) currentNode = currentNode.prev;
        }

        return currentNode;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public void set(int index, E element) {
        getNode(index).item = element;
    }

    @Override
    public E remove(int index) {
        BidirectionalNode<E> currentNode = getNode(index);
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;

        size--;
        return currentNode.item;
    }

    @Override
    public boolean removeItem(E element) {
        BidirectionalNode<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;
            if (currentNode.item == element) {
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
        size = 0;
        head = new BidirectionalNode<>(null);
        head.next = head;
        head.prev = head;
    }

    // 특징
    // 1. 양방향이므로, node 의 prev, next 둘 다 저장을 해줘야 한다
    // 2. 양방향이기 떄문에
}
