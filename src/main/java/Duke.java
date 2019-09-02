import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        greet();

        readFile();

        String text = input.next();
        while (!text.contentEquals("bye")) {
            printLine();
            switch (text) {
                case "list": {
                    list();
                    break;
                }
                case "done": {
                    done();
                    break;
                }
                case "delete": {
                    delete();
                    break;
                }
                default:
                    try {
                        tasks.add(Task.createTask(text,0,input.nextLine()));
                        add();
                    } catch (DukeException e){
                        print("OOPS!! I'm sorry, but I don't understand what that means.");
                    }
            }
            printLine();
            text = input.next();
        }
        exit();
    }

    private static void readFile() throws FileNotFoundException {
        String file = "data/duke.txt";
        Scanner reader = new Scanner(new File(file));
        while (reader.hasNextLine()){
            try {
                String type = reader.next();
                int status = reader.nextInt();
                Task task = Task.createTask(type, status, reader.nextLine());
                tasks.add(task);
            } catch (DukeException e) {
                print(e.getMessage());
            }
        }
        reader.close();
    }

    private static void writeToFile() throws IOException {
        PrintWriter writer = new PrintWriter("data/duke.txt");

        for (Task entry : tasks) {
            String append = entry.toFile();
            writer.append(append).append("\n");
        }
        writer.close();
    }

    private static void add() {
        print("Got it. I've added this task: ");
        print(tasks.get(tasks.size()-1).toString());
        printTasksInList();
    }

    private static void done() {
        try {
            int taskNumber = input.nextInt();
            if (--taskNumber < tasks.size()) {
                tasks.get(taskNumber).markAsDone();
                print("Nice! I've marked this task as done:");
                print("[" + tasks.get(taskNumber).getStatusIcon() + "] " + tasks.get(taskNumber).description);
                printTasksInList();
            } else {
                print("No such task number.");
            }
        } catch (NumberFormatException e) {
            print("Please enter a number.");
        }
    }

    private static void delete() {
        try {
            int taskNumber = input.nextInt();
            if (--taskNumber < tasks.size()) {
                print("Noted, I've removed this task:");
                print("[" + tasks.get(taskNumber).getStatusIcon() + "] " + tasks.get(taskNumber).description);
                tasks.remove(taskNumber);
                printTasksInList();
            } else {
                print("No such task number.");
            }
        } catch (NumberFormatException e) {
            print("Please enter a number.");
        }
    }

    private static void printTasksInList() {
        print("Now you have " + tasks.size() + " tasks in the list.");
    }

    private static void list() {
        print("Here are the tasks in your list:");
        for (int j = 0; j < tasks.size(); j++){
//        for (Task entry : tasks){
            String text = "\t" + (j+1) + "." + tasks.get(j).toString();
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
        printLine();
        print("Bye. Hope to see you soon!");
        printLine();
        try {
            writeToFile();
        } catch (IOException e) {
            print("Error writing to file.");
        }
    }

    private static void printLine() {
        print("_______________________________________________");
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
