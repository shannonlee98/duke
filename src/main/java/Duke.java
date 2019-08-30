import java.io.*;
import java.util.Scanner;

public class Duke {

    private static Scanner input = new Scanner(System.in);
    private static Task[] list = new Task[100];
    private static int numberOfTasks = 0;

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
                    try {
                        done(input.nextInt());
                    } catch (NumberFormatException e) {
                        print("Please enter a number.");
                    }
                    break;
                }
                default:
                    try {
                        list[numberOfTasks] = Task.createTask(text, 0, input.nextLine());
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
                list[numberOfTasks++] = task;
            } catch (DukeException e) {
                print(e.getMessage());
            }
        }
        reader.close();
    }

    public static void writeToFile() throws IOException {
        PrintWriter writer = new PrintWriter("data/duke.txt");

        for (int j = 0; j < numberOfTasks; j++) {
            String append = list[j].toFile();
            writer.append(append + "\n");
        }
        writer.close();
    }

    private static void add() {
        print("Got it. I've added this task: ");
        print(list[numberOfTasks].toString());
        print("Now you have " + ++numberOfTasks + " tasks in the list.");
    }

    private static void done(int taskNumber) throws NumberFormatException{
        if (--taskNumber < numberOfTasks) {
            list[taskNumber].markAsDone();
            print("Nice! I've marked this task as done: ");
            print("[" + list[taskNumber].getStatusIcon() + "] " + list[taskNumber].description);
        } else {
            print("No such task number.");
        }
    }

    private static void list() {
        print("Here are the tasks in your list:");
        for (int j = 0; j < numberOfTasks; j++){
            String text = "\t" + (j+1) + "." + list[j].toString();
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
