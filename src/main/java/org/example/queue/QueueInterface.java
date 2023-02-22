package org.example.queue;

public interface QueueInterface<E> {
    public void enqueue(E element);
    public E dequeue();
    public E front();

    public boolean isEmpty();
    public void dequeueAll();
}
