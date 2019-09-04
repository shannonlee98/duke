public class ListCommand extends Command{

    ListCommand() {
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showListMessage();
        for (Task entry : tasks.taskList) {
            ui.printTask(entry, tasks);
        }
    }
}
