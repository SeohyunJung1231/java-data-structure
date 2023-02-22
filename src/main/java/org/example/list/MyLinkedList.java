package org.example.list;

import org.example.list.node.Node;

public class MyLinkedList<E> implements ListInterface<E> {

    // 필드
    private Node<E> head; // 리스트이지만 헤드 하나만 갖고 있네!
    private int size;


    // 생성자
    public MyLinkedList() {
        head = new Node<>(null, null); // 더미헤드 (index = -1)
        size = 0;
    }


    // 매서드 : 필드를 다루는 기능들
    @Override
    public void add(int index, E element) {
        Node<E> previousNode = getNode(index - 1);
        Node<E> newNode = new Node(element, previousNode.next);
        previousNode.next = newNode;
        size++;
    }

    @Override
    public void append(E element) {
        Node<E> previousNode = head;
        while (previousNode.next != null) {
            previousNode = previousNode.next;
        }
        previousNode.next = new Node<E>(element, null);
        size++;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    private Node<E> getNode(int index) {
        if (index < -1 || index > size) throw new IndexOutOfBoundsException();
        Node<E> currentNode = head;
        for (int i = 0; i < index + 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public final int NOT_FOUND = -12345;
    @Override
    public int indexOf(E element) {
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            currentNode.next = currentNode;
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
        Node<E> currentNode = head;
        for (int i = 0; i<size; i++) {
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
        head = new Node<>(null, null);
    }
    // 특징
    // 1. getNode() 로 Node 객체를 가져와서 활용
    // 2. LinkedList 객체에는 head 정보만 가지고 있다
    // 3. currentNode = head 후 for 문으로 접근 가능
    // 4. next 매서드로 다다음 Node 로도 접근 가능하다
}
