public class Todo extends Task{

    public Todo(String description) {
        super(description);
    }

    public Todo(String description, int status) {
        super(description);
        if(status == 1) super.markAsDone();
    }

    @Override
    public String toString() {
        return "    [T]" + super.toString();
    }
}
