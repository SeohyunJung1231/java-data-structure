package org.example.queue;

import org.example.list.node.Node;

public class LinkedQueue<E> implements QueueInterface<E> { // 배열도 그렇고, 원형 자료구조를 착안하기 떄문에, CircularLinkedList 개념을 가져왔다
    // 필드
    private Node<E> tail;

    // 생성자
    public LinkedQueue() {
        tail = null;
    }


    // 매서드
    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        // 빈 큐였을 때
        if (isEmpty()) {
            tail = newNode;
            tail.next = newNode; // 원형 큐이기 떄문에, 자기 자신이 다음이 되어야 한다
        } else { // 비지 않은 큐였을 때
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        Node<E> temp = tail.next;
        // 큐가 만약 비었다면
        if (temp == tail) tail = null;
        // 큐가 안비었다면
        else tail.next = temp.next;

        return temp.item;
    }

    @Override
    public E front() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return tail.next.item;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void dequeueAll() {
        tail = null;
    }
    // 특징
    // 1. 더미헤드가 없으니까 큐가 비었을 때 / 안비었을 때 다 나눠서 생각해야 한다 ㅠㅠ
}
