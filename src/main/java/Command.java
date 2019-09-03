public class Command {

    boolean isExit;

    Command(){
        this.isExit = false;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) {
    }

    void print(String s) {
        System.out.println(s);
    }

    void showNumberOfRemainingTasks(TaskList taskList) {
        print("Now you have " + taskList.size() + " tasks in the list.");
    }

    void printTask(Task entry, TaskList tasks) {
        print("\t" + (tasks.indexOf(entry)+1) + "." + entry.toString());
    }

    boolean isExit() {
        return isExit;
    }
}
