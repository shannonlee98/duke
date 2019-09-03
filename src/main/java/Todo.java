import java.io.Reader;
import java.util.Scanner;

public class Todo extends Task{

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
