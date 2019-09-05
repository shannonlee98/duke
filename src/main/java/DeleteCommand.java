public class DeleteCommand extends Command {
    private int taskNumber;

    DeleteCommand(int command) {
        super();
        this.taskNumber = command;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (--taskNumber < tasks.size()) {
            ui.showDeleteMessage();
            ui.printTask(tasks.get(taskNumber), tasks);
            tasks.remove(taskNumber);
            ui.showNumberOfRemainingTasks(tasks);
        } else {
            throw new DukeException("I couldn't find a task with that number.");
        }
    }
}
