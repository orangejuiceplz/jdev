package main;

import types.SinglyLinkedList;
import java.util.Random;

public class TestLinkedLists {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Random random = new Random();

        for (int i = 0; i <5; i++) {
            list.append(random.nextInt(30));
        }
        list.display();

        System.out.println("----------------------------");

        list.append(5);
        list.display();

        System.out.println("----------------------------");

        System.out.println(list.getSize());
        System.out.println();

        System.out.println("----------------------------");

        list.deleteAt(5);
        list.display();
        System.out.println("----------------------------");
        list.insertAt(5, 3);
        list.display();

        System.out.println("----------------------------");

        list.reverse();
        list.display();

        list.reverseDisplay();



    }


}
