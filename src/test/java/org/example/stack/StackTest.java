package org.example.stack;

import org.example.stack.reuse.InheritedStack;
import org.example.stack.reuse.ListStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
//    StackInterface<Integer> stack = new ArrayStack<>();
//    StackInterface<Integer> stack = new LinkedListStack<>();
//    StackInterface<Integer> stack = new InheritedStack<>();
    StackInterface<Integer> stack = new ListStack<>();

    @Test
    public void stackTest() {
        stack.push(1);
        stack.push(2);


        assertEquals(stack.pop(), 2);
        assertEquals(stack.top(), 1);
        assertFalse(stack.isEmpty());

        assertEquals(stack.pop(), 1);
        assertTrue(stack.isEmpty());
    }

//    @Test // only for ArrayStack
//    public void ifFullTest() {
//        for (int i = 0; i < 64; i++) stack.push(1);
//
//        assertThrows(IndexOutOfBoundsException.class, () -> {
//            stack.push(1);
//        });
//    }

    @Test
    public void popAllTest() {
        stack.push(1);
        stack.push(2);

        stack.popAll();

        assertTrue(stack.isEmpty());
    }

}