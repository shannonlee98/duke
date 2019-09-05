class FindCommand extends Command {

    private String search;

    FindCommand(String command) {
        super();
        this.search = command.trim();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showFindMessage();
        for (Task entry : tasks.taskList) {
            if (entry.description.contains(search)) {
                ui.printTask(entry, tasks);
            }
        }
    }
}
