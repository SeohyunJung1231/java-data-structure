package org.example.list.node;

public class Node<E> {
    // 필드
    public E item; // DTO 여서 게터, 세터 대신 public 으로 풀었다.
    public Node<E> next;

    // 생성자
    public Node(E newItem) {
        item = newItem;
        next = null; // 다음 객체로 저장된 게 없음
    }

    public Node(E newItem, Node<E> nextNode) {
        item = newItem;
        next = nextNode;
    }
}
