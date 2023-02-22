package org.example.queue.reuse;

import org.example.list.ListInterface;
import org.example.list.MyArrayList;
import org.example.queue.QueueInterface;

public class ListQueue<E> implements QueueInterface<E> { // queue has a linked list

    // 필드
    ListInterface<E> list;

    // 생성자
    public ListQueue() {
        list = new MyArrayList<>(); // 여기서 구현체 지정
    }

    // 매서드
    @Override
    public void enqueue(E element) {
        list.append(element);
    }

    @Override
    public E dequeue() {
        return list.remove(0);
    }

    @Override
    public E front() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    @Override
    public void dequeueAll() {
        list.clear();
    }
}
