package org.example.queue;

import org.example.queue.reuse.InheritedQueue;
import org.example.queue.reuse.ListQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
//    QueueInterface<Integer> queue = new ArrayQueue<>();
//    QueueInterface<Integer> queue = new LinkedQueue<>();
//    QueueInterface<Integer> queue = new InheritedQueue<>();
    QueueInterface<Integer> queue = new ListQueue<>();

    @Test
    public void operatorTest() {
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(queue.front(), 1);
        assertEquals(queue.dequeue(), 1);
        assertFalse(queue.isEmpty());

        assertEquals(queue.front(), 2);
        assertEquals(queue.dequeue(), 2);
        assertTrue(queue.isEmpty());
    }

//    @Test only work for array queue
//    public void capacityTest() {
//        for (int i = 0; i < 64; i++) queue.enqueue(1);
//        assertThrows(IndexOutOfBoundsException.class, () -> {
//            queue.enqueue(2);
//        });
//    }

    @Test
    public void clearTest() {
        for (int i = 0; i < 10; i++) queue.enqueue(1);
        queue.dequeueAll();

        assertTrue(queue.isEmpty());
    }

}