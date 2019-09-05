import java.util.Scanner;

class Ui {
    Ui(){
    }

    void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        print(logo);

        showLine();
        print("Hello! I'm Duke\nWhat can I do for you");
        showLine();
    }

    void showLine() {
        print("_______________________________________________");
    }

    private void print(String s) {
        System.out.println(s);
    }

    String readCommand() {
        return new Scanner(System.in).nextLine();
    }

    void showError(DukeException e) {
        print(e.getMessage());
    }

    void showCommand(Task task, TaskList taskList) {
        print("Got it. I've added this task: ");
        print(task.toString());
        showNumberOfRemainingTasks(taskList);
    }

    void showNumberOfRemainingTasks(TaskList taskList) {
        print("Now you have " + taskList.size() + " tasks in the list.");
    }

    void printTask(Task entry, TaskList tasks) {
        print("\t" + tasks.indexOf(entry) + "." + entry.toString());
    }

    void showGoodbye() {
        print("Bye. Hope to see you soon!");
    }

    void showDeleteMessage() {
        print("Noted, I've removed this task:");
    }

    void showDoneMessage() {
        print("Nice! I've marked this task as done:");
    }

    void showFindMessage() {
        print("Here are the matching tasks in your list:");
    }

    void showListMessage() {
        print("Here are the tasks in your list:");
    }
}
