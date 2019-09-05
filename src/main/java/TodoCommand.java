import java.util.NoSuchElementException;

public class TodoCommand extends Command {

    private String description;

    TodoCommand(String description) throws DukeException {
        super();
        try{
            this.description = description;
        } catch (NoSuchElementException e) {
            throw new DukeException("Please enter a description for todo");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo todo = new Todo(this.description);
        tasks.add(todo);
        ui.showCommand(todo, tasks);
    }
}
