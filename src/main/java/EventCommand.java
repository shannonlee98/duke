import java.util.ArrayList;

class EventCommand extends AddCommand {

    String by;

    EventCommand(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event event = new Event(this.description, this.by);
        tasks.add(event);
        ui.showCommand(event, tasks);
    }

    @Override
    public void writeToFile(ArrayList<Task> tasks) {
        Event event = new Event(this.description, this.by);
        tasks.add(event);
    }
}
