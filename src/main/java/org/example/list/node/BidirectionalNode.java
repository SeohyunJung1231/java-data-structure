package org.example.list.node;

public class BidirectionalNode<E> {
    public E item;
    public BidirectionalNode<E> prev;
    public BidirectionalNode<E> next;


    // 생성자
    public BidirectionalNode() {
        prev = null;
        next = null;
    }

    public BidirectionalNode(E newItem) {
        item = newItem;
        prev = null;
        next = null;
    }

    public BidirectionalNode(E newItem, BidirectionalNode<E> previousNode, BidirectionalNode<E> nextNode) {
        item = newItem;
        prev = previousNode;
        next = nextNode;
    }

}
