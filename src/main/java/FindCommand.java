import java.util.Scanner;

class FindCommand extends Command {

    private String search;

    FindCommand(Scanner command) {
        super();
        this.search = command.nextLine();
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
