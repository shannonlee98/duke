public class ListCommand extends Command{

    ListCommand() {
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        print("Here are the tasks in your list:");
        for (Task entry : tasks.taskList){
            printTask(entry, tasks);
        }
    }
}
