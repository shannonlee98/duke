import java.util.Scanner;

class Ui {

    Ui(){
    }

    void showLoadingError() {
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

    void showError(String message) {
        print(message);
    }
}
