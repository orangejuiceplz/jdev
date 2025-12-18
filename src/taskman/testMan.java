package taskman;

public class testMan {
    public static void main(String[] args) {
        TaskManager man = new TaskManager();
        man.addTask(1, "Task 1", "2005/12/01");
        man.addTask(97, "Task 97", "2005/11/31");
        man.addTask(2, "Task 2", "1997/01/01");
        man.displayAll();
        System.out.println("----------------------");
        man.removeTask(2);
        man.displayAll();
        System.out.println("----------------------");
        man.searchTaskByDeadline("2005/12/01");
        System.out.println("----------------------");
        man.displayNext();


    }
}
