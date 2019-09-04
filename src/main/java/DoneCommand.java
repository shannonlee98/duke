import java.util.Scanner;

public class DoneCommand extends Command {
    private int taskNumber;

    DoneCommand(Scanner command) {
        super();
        this.taskNumber = command.nextInt();
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            if (--taskNumber < tasks.size()) {
                tasks.get(taskNumber).markAsDone();
                ui.showDoneMessage();
                ui.printTask(tasks.get(taskNumber), tasks);
                ui.showNumberOfRemainingTasks(tasks);
            } else {
                ui.showError("No such task number.");
            }
        } catch (NumberFormatException e) {
            ui.showError("Please enter a number.");
        }
    }
}
