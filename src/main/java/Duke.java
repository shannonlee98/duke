import java.util.Scanner;
public class Duke {

    private static Scanner input = new Scanner(System.in);
    private static Task[] list = new Task[100];
    private static int i = 0;

    public static void main(String[] args) {
        greet();

        String text = input.nextLine();
        while(!(text.contentEquals("bye"))){
            printLine();
            if (text.contentEquals("list")) {
                list();
            } else if (text.contains("done ") && text.substring(0, 5).contentEquals("done ")) {
                done(text.substring(5));
            } else {
                add(text);
            }
            printLine();
            text = input.nextLine();
        }
        exit();
    }

    private static void done(String text) {
        int taskNumber = Integer.parseInt(text) - 1;
        if (taskNumber < i) {
            list[taskNumber].markAsDone();
            print("Nice! I've marked this task as done: ");
            print("[" + list[taskNumber].getStatusIcon() + "] " + list[taskNumber].description);
        }
    }

    private static void add(String text) {
        Task t = new Task(text);
        print("added: " + t.description);

        list [i] = t;
        i++;
    }

    private static void list() {
        print("Here are the tasks in your list:");
        for (int j = 0; j < i; j++){
            String text = (char) j+1 + ". [" + list[j].getStatusIcon() + "] " + list[j].description;
            print(text);
        }
    }

    private static void greet() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        print(logo);

        printLine();
        print("Hello! I'm Duke\nWhat can I do for you");
        printLine();
    }

    private static void exit() {
        print("Bye. Hope to see you soon!");
    }

    public static void printLine() {
        print("_______________________________________________");
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
