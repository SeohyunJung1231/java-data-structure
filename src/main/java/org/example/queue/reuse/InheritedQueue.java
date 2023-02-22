package org.example.queue.reuse;

import org.example.list.MyLinkedList;
import org.example.list.node.Node;
import org.example.queue.QueueInterface;

public class InheritedQueue<E> extends MyLinkedList<E> implements QueueInterface<E> { // queue is linked list


    // 생성자
    public InheritedQueue() {
        super();
    }

    // 매서드
    @Override
    public void enqueue(E element) {
        append(element);
    }

    @Override
    public E dequeue() {
        return remove(0);
    }

    @Override
    public E front() {
        return get(0);
    }

    @Override
    public void dequeueAll() {
        clear();
    }
    // 특징
    // 1. 꼬리로 들어와서, 머리로 나간다!
}
