package org.example.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackApplicationTest {

    @Test
    public void reverseString() {
        // given
        String givenString = "abcdefg";

        // when
        String reversed = reverse(givenString);

        // then
        assertEquals(reversed, "gfedcba");

    }

    private String reverse(String str) {
        // stack 에 넣는다
        StackInterface<Character> stack = new ArrayStack<>();
        for (char character : str.toCharArray()) stack.push(character);

        // stack 에서 하나씩 꺼내어 새로 만든다
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) result.append(stack.pop());

        return result.toString();
    }

    @Test
    public void calculatePostfix() {
        String[] postfix = "700 3 47 + 6 * - 4 /".split(" ");

        assertEquals(evaluate(postfix), 100);
    }

    private int evaluate(String[] postfix) {
        StackInterface<Integer> stack = new ArrayStack<>();
        for (String str : postfix) {
            // 숫자만 stack 에 넣는다
            if (!isOperator(str)) stack.push(Integer.parseInt(str));
            // 연산자인 경우, stack 에 있는 숫자를 계산한다
            else {
                char operator = str.toCharArray()[0];
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(operation(num2, num1, operator)); // 위치가 반대네
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String operator) {
        return operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/");
    }

    private int operation(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        return result;
    }
}
