package taskman;
public class Task {

    private int id;
    private String description;
    private String deadline;
    private Task nextTask;

    public Task(int id, String description, String deadline) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.nextTask = null;
    }

    public int getID() {
        return this.id;
    }
    public void setID(int id) {
        this.id = id;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDeadline() {
        return this.deadline; // return it in a specific format
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Task getNextTask() {
        return this.nextTask;
    }

    public void setNextTask(Task nextTask) {
        this.nextTask = nextTask;
    }

    public String toString() {
        return "ID: " + this.id + ", Description: " + this.description + ", Deadline: " + this.deadline;
    }
}