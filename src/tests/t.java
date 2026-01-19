package tests.stacksandqueues;

import java.util.InputMismatchException;
import java.util.Scanner;

public class t {

    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();
        Scanner scanner = new Scanner(System.in);

        int people = 0;
        while (true) {
            System.out.print("How many people are on line: ");
            try {
                people = scanner.nextInt();
                if (people > 0) {
                    break; /
                } else {
                    System.out.println("People must be greater than 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        }
        
        scanner.nextLine(); 

        String person;
        for (int i = 0; i < people; i++) {
            while (true) {
                System.out.print("Please enter person " + (i + 1) + " (no spaces): ");
                
                person = scanner.nextLine().trim();

                if (person.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                } else if (person.contains(" ")) {
                    System.out.println("Error: There cannot be any spaces. Try again.");
                } else {
                    queue.enqueue(person);
                    break;
                }
            }
        }

        int cars = 0;
        while (true) {
            System.out.print("How many cars on each coaster: ");
            try {
                cars = scanner.nextInt();
                if (cars > 0) break;
                System.out.println("There must be at least 1 car.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        int seats = 0;
        while (true) {
            System.out.print("How many seats in each car: ");
            try {
                seats = scanner.nextInt();
                if (seats > 0) break;
                System.out.println("There must be at least 1 seat.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        }

        int runs = 0;
        while (true) {
            System.out.print("How many times should each coaster run: ");
            try {
                runs = scanner.nextInt();
                if (runs >= 0) break;
                System.out.println("Runs must be nonnegative");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
            }
        }

        for (int i = 0; i < runs; i++) {
            System.out.println("\nRun " + (i + 1));
            System.out.println("-------------");

            for (int j = 0; j < seats * cars; j++) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.dequeue());
                }
            }
        }

        System.out.println("----------------");
        System.out.println("Line");
        if (queue.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }
        }
        System.out.println("-------------");
    }
}
