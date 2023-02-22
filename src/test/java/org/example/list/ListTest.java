package org.example.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
//    ListInterface<Integer> myList = new MyArrayList<>();
//    ListInterface<Integer> myList = new MyLinkedList<>();
//    ListInterface<Integer> myList = new CircularLinkedList<>();
    ListInterface<Integer> myList = new CircularDoublyLinkedList<>();



    @Test
    public void addTest() {

        myList.add(0, 3);
        myList.add(1, 4);
        myList.add(0, 2);

        assertEquals(myList.get(0), 2);
        assertEquals(myList.get(1), 3);
        assertEquals(myList.get(2), 4);
        assertEquals(myList.len(), 3);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.add(-1, 3);
        });
    }

    @Test
    public void appendTest() {
        myList.append(1);
        myList.append(2);

        assertEquals(myList.get(1), 2);
    }

    @Test
    public void removeTest() {
        myList.add(0, 1);
        myList.add(1, 2);
        myList.add(2, 3);

        assertEquals(myList.remove(1), 2);
        assertEquals(myList.get(1), 3);
        assertEquals(myList.len(), 2);
    }

    @Test
    public void removeIndexTest() {
        myList.add(0, 1);
        myList.add(1, 2);
        myList.add(2, 3);

        myList.removeItem(2);

        assertEquals(myList.len(), 2);
        assertEquals(myList.get(1), 3);
    }
    // set, indexOf, .. 함수들 추가 테스트 필요
}