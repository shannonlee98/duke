import java.util.ArrayList;

class DeadlineCommand extends AddCommand {

    String by;

    DeadlineCommand(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline deadline = new Deadline(this.description, this.by);
        tasks.add(deadline);
        ui.showCommand(deadline, tasks);
    }

    @Override
    public void writeToFile(ArrayList<Task> tasks) {
        Deadline deadline = new Deadline(this.description, this.by);
        tasks.add(deadline);
    }
}
