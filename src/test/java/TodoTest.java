public class TodoTest extends Task{

    TodoTest(String description) {
        super(description);
    }

    TodoTest(int status, String description) {
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
