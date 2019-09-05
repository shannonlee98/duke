public class DoneCommand extends Command {
    private int taskNumber;

    DoneCommand(int command) {
        super();
        this.taskNumber = command;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (--taskNumber < tasks.size()) {
            tasks.get(taskNumber).markAsDone();
            ui.showDoneMessage();
            ui.printTask(tasks.get(taskNumber), tasks);
            ui.showNumberOfRemainingTasks(tasks);
        } else {
            throw new DukeException("I couldn't find a task with that number.");
        }
    }
}
