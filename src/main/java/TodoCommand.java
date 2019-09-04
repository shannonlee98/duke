import java.util.ArrayList;
public class TodoCommand extends AddCommand {
    TodoCommand(String description) {
        super(description);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo todo = new Todo(this.description);
        tasks.add(todo);
        ui.showCommand(todo, tasks);
    }

    @Override
    public void writeToFile(ArrayList<Task> tasks) {
        Todo todo = new Todo(this.description);
        tasks.add(todo);
    }
}
