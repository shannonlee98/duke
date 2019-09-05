class DeadlineCommand extends Command {

    private String description;
    private String by;

    DeadlineCommand(String description, String by) {
        super();
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline deadline = new Deadline(this.description, this.by);
        tasks.add(deadline);
        ui.showCommand(deadline, tasks);
    }
}
