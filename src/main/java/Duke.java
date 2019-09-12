import java.util.NoSuchElementException;
import java.util.Scanner;

public class Duke {

    private Storage storage;
    private static TaskList tasks;
    private Ui ui;

    private Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showError(e);
            tasks = new TaskList();
        }
    }

    private void run() {
        ui.showWelcome();
        boolean isExit = false;
        Scanner input = new Scanner(System.in);
        while (!isExit) {
            try {
                String command = ui.readCommand(input);
                ui.showLine();
                Command c = Parser.parse(command);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (NoSuchElementException e) {
                isExit = true;
            } catch (DukeException e) {
                ui.showError(e);
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke("C:\\Users\\shank\\Desktop\\OOP\\duke\\data\\duke.txt").run();
    }
}
