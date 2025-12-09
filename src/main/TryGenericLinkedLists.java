package main;

import types.generic.SinglyLinkedList;

import java.util.Random;

public class TryGenericLinkedLists {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            list.append(random.nextInt(10));
        }

        list.display();
        list.addFirst(3);
        list.display();
        list.add(3, 67);
        list.display();
        list.add(list.getSize(), 3204);
        list.display();
        System.out.println();
        list.replace(list.getSize() - 1, 99);
        list.display();

        list.append(5);
        list.append(6);
        list.append(7);
        list.append(8);
        list.append(9);
        list.append(10);
        System.out.println(list.search(8));
        System.out.println(list.removeValue(8));


    }

}