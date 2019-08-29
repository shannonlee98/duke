public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "✓" : "✗");
    }

    public String getDescription() {
        return this.description;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.description;
    }

    public String toFile() {
        return this.getStatus() + this.description;
    }

    public int getStatus() {
        return (isDone ? 1 : 0);
    }

    public static Task createTask(String type, int status, String reader, boolean isNewTask) throws DukeException {
        try {
            String[] entry = reader.split("\\|");
            switch (type){
                case "T": return new Todo(status, entry[0]);
                case "D": {
//                    String by[] = entry[1].split("by");
                    return new Deadline(status, entry[0], entry[1]);
                }
                case "E": {
//                    String at[] = entry[1].split("at");
                    return new Event(status, entry[0], entry[1]);
                }
                default: throw new DukeException();
            }
        } catch (NumberFormatException | DukeException e) {
            throw new DukeException("Invalid format");
        }
    }

//    public static Task createTask(String type, String reader){
//
//    }
}