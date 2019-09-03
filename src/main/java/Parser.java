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
            default: throw new DukeException();
//                try {
//                    tasks.add(Task.createTask(text,0,input.nextLine()));
//                    add();
//                } catch (DukeException e){
//                    print("OOPS!! I'm sorry, but I don't understand what that means.");
//                }
            }
    }

//    private static void add() {
//        print("Got it. I've added this task: ");
//        print(tasks.get(tasks.size()-1).toString());
//        printTasksInList();
//    }
}
