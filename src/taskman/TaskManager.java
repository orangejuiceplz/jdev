package taskman;

import java.util.NoSuchElementException;

public class TaskManager {

    private Task firstTask;


    public void addTask(int id, String description, String deadline) {
        Task task = new Task(id, description, deadline);

        if (firstTask == null) {
            firstTask = task;
            return;
        }

        if (isBefore(task.getDeadline(), firstTask.getDeadline())) {
            task.setNextTask(firstTask);
            firstTask = task;
            return;
        }

        Task current = firstTask;
        while (current.getNextTask() != null && isBefore(current.getNextTask().getDeadline(), task.getDeadline())) {
            current = current.getNextTask();
        }

        task.setNextTask(current.getNextTask());
        current.setNextTask(task);
    }

    public void removeTask(int id) {

        if (firstTask == null) throw new NoSuchElementException("list is empty, so the ID can't exist");

        if (firstTask.getID() == id) {
            firstTask = firstTask.getNextTask();
            return;
        }

        Task current = firstTask;
        while (current.getNextTask() != null) {

            if (current.getNextTask().getID() == id) {
                current.setNextTask(current.getNextTask().getNextTask());
                return;
            }
            current = current.getNextTask();
        }
        throw new NoSuchElementException("ID is not in the list");
    }

    public void displayAll() {
        Task current = firstTask;

        while (current != null) {
            System.out.print(current + "\n");
            current = current.getNextTask();
        }
    }

    public void displayNext() {
        if (firstTask == null) {
            throw new NoSuchElementException("List is empty");
        }
        System.out.println(firstTask);
    }

    public void searchTaskByDeadline(String deadLine) {
        System.out.println("Tasks due by " + deadLine + ": ");

        Task current = firstTask;
        boolean didWeFindAny = false;
        while (current != null) {
            if (isBefore(current.getDeadline(), deadLine)) {
                System.out.println(current);
                didWeFindAny = true;
            } else {
                break;
            }
            current = current.getNextTask();
        }
        if (!didWeFindAny) {
        throw new NoSuchElementException("No tasks due by that date");
        }
    }




    /**
     * @param firstDate
     * first deadline. must be in YYYY/MM/DD to work
     * @param secondDate
     * second deadline. must be in YYYY/MM/DD to work
     * @return
     * return if the first date is before the second date
     */
    private boolean isBefore(String firstDate, String secondDate) {
        int deadLine1 = stripSlashesAndConvert(firstDate);
        int deadLine2 = stripSlashesAndConvert(secondDate);
        return deadLine1 <= deadLine2;
    }

    private int stripSlashesAndConvert(String str) {
        str = str.replace("/", "");
        return Integer.parseInt(str);
    }











}
