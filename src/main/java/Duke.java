import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        printLine("Hello! I'm Duke\nWhat can I do for you");

        String text = input.nextLine();
        while(!(text.contentEquals("bye"))){
            printLine(text);
        }
        printLine("Bye. Hope to see you soon!");
    }

    public static void printLine(String text){
        System.out.println("_______________________________________________");
        System.out.println(text);
        System.out.println("_______________________________________________");
    }
}
