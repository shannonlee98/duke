import java.util.Scanner;

class FindCommand extends Command {

    private String search;

    FindCommand(Scanner command) {
        super();
        this.search = command.nextLine();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        print("Here are the matching tasks in your list:");
        for (Task entry : tasks.taskList) {
            if (entry.description.contains(search)) {
                printTask(entry, tasks);
            }
        }
    }
}
