import java.util.Scanner;

public class DeleteCommand extends Command {
    private int taskNumber;

    DeleteCommand(Scanner command) {
        super();
        this.taskNumber = command.nextInt();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            if (--taskNumber < tasks.size()) {
                ui.showDeleteMessage();
                ui.printTask(tasks.get(taskNumber), tasks);
                tasks.remove(taskNumber);
                ui.showNumberOfRemainingTasks(tasks);
            } else {
                ui.showError("No such task number.");
            }
        } catch (NumberFormatException e) {
            ui.showError("Please enter a number.");
        }
    }
}
