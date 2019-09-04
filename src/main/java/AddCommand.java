import java.util.ArrayList;

abstract class AddCommand extends Command{

    String description;

    public AddCommand(String description) {
        this.description = description;
    }

    public void writeToFile(ArrayList<Task> tasks) {
    }
}
