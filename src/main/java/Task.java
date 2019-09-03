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
        return this.getStatus() + this.description;
    }

    private int getStatus() {
        return (isDone ? 1 : 0);
    }

    static Task createTask(String type, int status, String reader) throws DukeException {
        try {
            reader = reader.replace("/at", "|");
            reader = reader.replace("/by", "|");
            String[] entry = reader.split("\\|",2);
            switch (type){
                case "T":
                case "todo":
                    return new Todo(status, entry[0]);
                case "D":
                case "deadline":{
                    return new Deadline(status, entry[0], entry[1]);
                }
                case "E":
                case "event": {
                    return new Event(status, entry[0], entry[1]);
                }
                default: throw new DukeException();
            }
        } catch (NumberFormatException | DukeException e) {
            throw new DukeException("Invalid format");
        }
    }
}