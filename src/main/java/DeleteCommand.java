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
                print("Noted, I've removed this task:");
                printTask(tasks.get(taskNumber), tasks);
                tasks.remove(taskNumber);
                showNumberOfRemainingTasks(tasks);
            } else {
                print("No such task number.");
            }
        } catch (NumberFormatException e) {
            print("Please enter a number.");
        }
    }
}
