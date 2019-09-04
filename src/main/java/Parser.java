import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Parser {
    public Parser(){

    }

    static Command parse(String input) throws DukeException{
        Scanner command = new Scanner(input);
        switch (command.next()) {
            case "bye": return new ByeCommand();
            case "list": return new ListCommand();
            case "done": return new DoneCommand(command);
            case "delete": return new DeleteCommand(command);
            case "find": return new FindCommand(command);
            case "todo":return new TodoCommand(command.nextLine().trim());
            case "deadline": return parseDeadline(command.nextLine());
            case "event": return parseEvent(command.nextLine());
            default: throw new DukeException();
//                try {
//                    tasks.add(Task.createTask(text,0,input.nextLine()));
//                    add();
//                } catch (DukeException e){
//                    print("OOPS!! I'm sorry, but I don't understand what that means.");
//                }
            }
    }

    public static Task parseTask(String input) throws DukeException{
        Scanner command = new Scanner(input);
        String type = command.next();
        int status = command.nextInt();
        switch (type) {
            case "T": return new Todo(status, command.nextLine().trim());
            case "D": return parseDeadline(status, command.nextLine());
            case "E": return parseEvent(status, command.nextLine());
            default: throw new DukeException();
        }
    }

    private static Command parseEvent(String description) {
        String replace = description.replace("/at", "|");
        String[] entry = replace.split("\\|",2);
        return new EventCommand(entry[0].trim(), entry[1].trim());
    }

    private static Event parseEvent(int status, String description) {
        String replace = description.replace("/at", "|");
        String[] entry = replace.split("\\|",2);
        return new Event(status, entry[0].trim(), entry[1].trim());
    }

    private static Command parseDeadline(String description) {
        String replace = description.replace("/by", "|");
        String[] entry = replace.split("\\|",2);
        return new DeadlineCommand(entry[0].trim(), entry[1].trim());
    }

    private static Deadline parseDeadline(int status, String description) {
        String replace = description.replace("/by", "|");
        String[] entry = replace.split("\\|",2);
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
