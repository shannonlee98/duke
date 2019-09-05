class EventCommand extends Command {

    private String description;
    private String by;

    EventCommand(String description, String by) {
        super();
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event event = new Event(this.description, this.by);
        tasks.add(event);
        ui.showCommand(event, tasks);
    }
}
