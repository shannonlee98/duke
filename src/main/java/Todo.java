public class Todo extends Task{

    Todo(String description) {
        super(description);
    }

    Todo(int status, String description) {
        super(description);
        if(status == 1) super.markAsDone();
    }

    @Override
    public String toFile() {
        return "T " + super.toFile();
    }

    @Override
    public String toString() {
        return "    [T]" + super.toString();
    }
}
