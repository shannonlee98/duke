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
                print("Nice! I've marked this task as done:");
                printTask(tasks.get(taskNumber), tasks);
                showNumberOfRemainingTasks(tasks);
            } else {
                print("No such task number.");
            }
        } catch (NumberFormatException e) {
            print("Please enter a number.");
        }
    }
}
