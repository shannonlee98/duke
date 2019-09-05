import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ByeCommand extends Command{

    ByeCommand() {
        super();
        isExit = true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ui.showGoodbye();
        try {
            writeToFile(tasks.taskList);
        } catch (FileNotFoundException e) {
            throw new DukeException("I couldn't find the file to write to.");
        }
    }

    private void writeToFile(ArrayList<Task> taskList) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("data/duke.txt");
        for (Task entry : taskList) {
            String append = entry.toFile();
            writer.append(append).append("\n");
        }
        writer.close();
    }
}
