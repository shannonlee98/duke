public class Command {

    boolean isExit;

    Command(){
        isExit = false;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
    }

    boolean isExit() {
        return isExit;
    }
}
