import java.util.Scanner;
public class Duke {

    private static Scanner input = new Scanner(System.in);
    private static String list[] = new String[100];
    private static int i = 0;

    public static void main(String[] args) {

        greet();

        String text = input.nextLine();
        while(!(text.contentEquals("bye"))){
            if (text.contentEquals("list")){
                list();
            } else {
                echo(text);
                add(text);
            }
            text = input.nextLine();
        }
        exit();
    }

    private static void add(String text) {
        list[i] = text;
        i++;
    }

    private static void list() {
        for (int j = 0; j < i; j++){
            System.out.println((char) j+1 + ". " + list[j]);
        }
    }

    private static void greet() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);

        printLine("Hello! I'm Duke\nWhat can I do for you");
    }

    private static void echo(String text) {
        printLine("added: " + text);
    }

    private static void exit() {
        printLine("Bye. Hope to see you soon!");
    }

    public static void printLine(String text){
        System.out.println("_______________________________________________");
        System.out.println(text);
        System.out.println("_______________________________________________");
    }
}
