package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import types.LinkedList;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedLists {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Random random = new Random();

        for (int i = 0; i <5; i++) {
            list.append(random.nextInt(30));
        }
        list.display();

        System.out.println(list.getSize());
        System.out.println();

        list.sort();
        list.display();

    }


}
