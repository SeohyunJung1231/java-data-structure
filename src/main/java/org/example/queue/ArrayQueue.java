package org.example.queue;

public class ArrayQueue<E> implements QueueInterface<E> {

    // 필드 (원형 배열인 것을 감안)
    private int frontIndex, tailIndex, size;
    E[] queue;

    private static final int DEFAULT_CAPACITY = 64;


    // 생성자
    public ArrayQueue() {
        queue = (E[]) new Object[DEFAULT_CAPACITY];

        frontIndex = 0;
        tailIndex = DEFAULT_CAPACITY - 1; // 초기값! - 하나 추가될 때마다 값이 1씩 추가되니까 front 로 가게 되어있다
        size = 0;
    }

    public ArrayQueue(int capacity) {
        queue = (E[]) new Object[capacity];

        frontIndex = 0;
        tailIndex = capacity - 1;
        size = 0;
    }


    // 매서드
    @Override
    public void enqueue(E element) {
        // 배열기반은 스택이든 큐든 capacity 넘었는지 확인해야 함
        if (isFull()) throw new IndexOutOfBoundsException();

        tailIndex = (tailIndex + 1) % queue.length; // queue.length 는 capacity 이다
        queue[tailIndex] = element;
        size++;
    }

    private boolean isFull() {
        return size == queue.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IndexOutOfBoundsException();

        E frontElement = queue[frontIndex];
        frontIndex = (frontIndex + 1) % queue.length;
        size--;

        return frontElement;
    }

    @Override
    public E front() {
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return queue[frontIndex];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void dequeueAll() {
        queue = (E[]) new Object[queue.length];

        size = 0;
        frontIndex = 0;
        tailIndex = queue.length - 1;
    }
}
