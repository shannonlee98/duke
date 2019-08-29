import java.util.Scanner;
public class Duke {

    private static Scanner input = new Scanner(System.in);
    private static Task[] list = new Task[100];
    private static int numberOfTasks = 0;

    public static void main(String[] args) {
        greet();

        String text = input.nextLine();
        while(!(text.contentEquals("bye"))){
            printLine();
            if (text.contentEquals("list")) {
                list();
            } else if (text.startsWith("done")) {
                try{
                    done(text.substring(4));
                } catch (NumberFormatException e) {
                    print("Please enter a number.");
                }
            } else if (text.startsWith("todo")){
                try{
                    list[numberOfTasks] = new Todo(text.substring(5));
                    add();
                } catch (StringIndexOutOfBoundsException e) {
                    print("OOPS!! The description of a todo cannot be empty.");
                }
            } else if (text.startsWith("deadline")) {
                try{
                    int index = text.indexOf("/by");
                    String time = text.substring(index + 3);
                    list[numberOfTasks] = new Deadline(text.substring(9,index), time);
                    add();
                } catch (StringIndexOutOfBoundsException e) {
                    print("OOPS!! The description or time of a deadline cannot be empty.");
                }
            } else if (text.startsWith("event")){
                try{
                    int index = text.indexOf("/at");
                    String time = text.substring(index + 3);
                    list[numberOfTasks] = new Event(text.substring(6,index), time);
                    add();
                } catch (StringIndexOutOfBoundsException e) {
                    print("OOPS!! The description or time of an event cannot be empty.");
                }
            } else {
                print("OOPS!! I'm sorry, but I don't understand what that means.");
            }
            printLine();
            text = input.nextLine();
        }
        exit();
    }

    private static void done(String text) throws NumberFormatException{
        if(text.length() < 2){
            throw new NumberFormatException();
        }
        int taskNumber = Integer.parseInt(text.substring(1)) - 1;
        if (taskNumber < numberOfTasks) {
            list[taskNumber].markAsDone();
            print("Nice! I've marked this task as done: ");
            print("[" + list[taskNumber].getStatusIcon() + "] " + list[taskNumber].description);
        } else {
            print("No such task number.");
        }
    }

    private static void add() {
        print("Got it. I've added this task: ");
        print(list[numberOfTasks].toString());
        print("Now you have " + ++numberOfTasks + " tasks in the list.");
    }

    private static void list() {
        print("Here are the tasks in your list:");
        for (int j = 0; j < numberOfTasks; j++){
            String text = (char) j+1 + ". " + list[j].toString();
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

    private static void printLine() {
        print("_______________________________________________");
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
