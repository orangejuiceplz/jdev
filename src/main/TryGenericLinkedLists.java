package main;

import types.generic.SinglyLinkedList;

import java.util.Random;

public class TryGenericLinkedLists {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Random random = new Random();

        list.display();
        list.addFirst(3);
        list.display();

    }

}