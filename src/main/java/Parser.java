import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Parser {

    static Command parse(String input) throws DukeException{
        Scanner command = new Scanner(input);
        try{
            switch (command.next()) {
                case "bye": return new ByeCommand();
                case "list": return new ListCommand();
                case "done": return new DoneCommand(command.nextInt());
                case "delete": return new DeleteCommand(command.nextInt());
                case "find": return new FindCommand(command.nextLine().trim());
                case "todo": return new TodoCommand(command.nextLine().trim());
                case "deadline": return parseDeadline(command.nextLine());
                case "event": return parseEvent(command.nextLine());
                default: throw new DukeException("Oops! I'm sorry, but I don't understand what that means.");
            }
        } catch (NoSuchElementException e) {
            throw new DukeException("Please enter a valid command format.");
        }
    }

    static Task parseTask(String input) throws DukeException{
        Scanner command = new Scanner(input);
        String type = command.next();
        int status = command.nextInt();
        switch (type) {
            case "T": return new Todo(status, command.nextLine().trim());
            case "D": return parseDeadline(status, command.nextLine());
            case "E": return parseEvent(status, command.nextLine());
            default: throw new DukeException("I found an invalid entry in the file.");
        }
    }

    private static Command parseEvent(String description) throws DukeException {
        String replace = description.replace("/at", "|");
        String[] entry = replace.split("\\|",2);
        if (entry.length < 2) {
            throw new DukeException("Please enter your event in the format:\n" +
                    "event event-name /at datetime");
        }
        return new EventCommand(entry[0].trim(), entry[1].trim());
    }

    private static Event parseEvent(int status, String description) throws DukeException {
        String replace = description.replace("/at", "|");
        String[] entry = replace.split("\\|",2);
        if (entry.length < 2) {
            throw new DukeException("I found an event with an invalid format in your file.");
        }
        return new Event(status, entry[0].trim(), entry[1].trim());
    }

    private static Command parseDeadline(String description) throws DukeException {
        String replace = description.replace("/by", "|");
        String[] entry = replace.split("\\|",2);
        if (entry.length < 2) {
            throw new DukeException("Please enter your deadline in the format:\n" +
                    "deadline deadline-name /by datetime");
        }
        return new DeadlineCommand(entry[0].trim(), entry[1].trim());
    }

    private static Deadline parseDeadline(int status, String description) throws DukeException {
        String replace = description.replace("/by", "|");
        String[] entry = replace.split("\\|",2);
        if (entry.length < 2) {
            throw new DukeException("I found an event with an invalid format in your file.");
        }
        return new Deadline(status, entry[0].trim(), entry[1].trim());
    }

    static Date setDatetime(String by) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(by);
        } catch (ParseException e) {
            return null;
        }
    }
}
