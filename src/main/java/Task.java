public class Task {
    String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return (isDone ? "✓" : "✗");
    }

    void markAsDone() {
        this.isDone = true;
    }

    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String toFile() {
        return this.getStatus() + " " + this.description;
    }

    private int getStatus() {
        return (isDone ? 1 : 0);
    }

}