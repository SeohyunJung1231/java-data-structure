package org.example.queue;

import org.example.stack.LinkedListStack;
import org.example.stack.StackInterface;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.*;

public class QueueApplicationTest {
    @Test
    public void palindromeTest() {
        assertTrue(isPalindrome("lioninoil"));
        assertFalse(isPalindrome("fiekfj"));
    }

    private boolean isPalindrome(String str) {
        // 스택과 큐에 모두 넣는다.
        StackInterface<Character> stack = new LinkedListStack<>();
        QueueInterface<Character> queue = new LinkedQueue<>();
        for (char character : str.toCharArray()) {
            stack.push(character);
            queue.enqueue(character);
        }

        // 스택과 큐에서 하나씩 원소를 뺄 때, 모두 값들이 같은지 확인한다
        while (!stack.isEmpty() && stack.pop() == queue.dequeue()) ;
        return stack.isEmpty();
    }

    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        for (int element : arr) {
            if (element != stack.peek()) stack.push(element);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
