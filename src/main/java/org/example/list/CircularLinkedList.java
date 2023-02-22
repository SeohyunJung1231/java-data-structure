package org.example.list;

import org.example.list.node.Node;

public class CircularLinkedList<E> implements ListInterface<E> {
    // 필드
    private Node<E> tail; // 더미해드와 연결된 마지막 노드
    private int size;

    // 생성자
    public CircularLinkedList() {
        tail = new Node(-1); // 기본값 설정
        tail.next = tail; // circular 이므로, 자신 다음은 자신을 가르키고 있다
        size = 0;
    }


    @Override
    public void add(int index, E element) {

        Node<E> previousNode = getNode(index - 1);
        Node<E> newNode = new Node<>(element, previousNode.next);
        previousNode.next = newNode;

        if (index == size) tail = newNode;
        size++;
    }

    @Override
    public void append(E element) {
        Node<E> previousNode = tail;
        Node<E> currentNode = new Node<>(element, tail.next); // 더미헤드 연결할 tail

        previousNode.next = currentNode;
        tail = currentNode;

        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    private Node<E> getNode(int index) {
        if (index < -1 || index > size) throw new IndexOutOfBoundsException();
        Node<E> currentNode = tail.next; // 헤드를 가르킴
        for (int i = 0; i < index + 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E element) {
        Node<E> currentNode = tail.next; // 더미헤드
        for (int i = 0; i < size; i++) {
            currentNode = currentNode.next;
            if (currentNode.item == element) return i;
        }
        return NOT_FOUND;
    }

    @Override
    public void set(int index, E element) {
        getNode(index).item = element;
    }

    @Override
    public E remove(int index) {
        Node<E> previousNode = getNode(index - 1);
        Node<E> currentNode = previousNode.next;
        previousNode.next = currentNode.next;
        size--;
        return currentNode.item;
    }

    @Override
    public boolean removeItem(E element) {
        Node<E> currentNode = tail.next; // 더미헤드
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
        tail = new Node(-1);
        tail.next = tail;
    }

    // 특징
    // 1. tail -> dummyHead -> nodes 이 순으로 간다. 따라서, index 로 get 할 떄 for 문을 한번 더 돌아야 한다.
    //      cf) LinkedList 는 dummyHead -> nodes 순으로 감
    // 2. head 는 dummy head 여서 바뀔 일이 없지만, tail 은 바뀔 수 있으므로, 추가 로직이 들어간다 (더미헤드의 장점!)

}
