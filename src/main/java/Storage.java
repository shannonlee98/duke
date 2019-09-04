import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Storage {

    private String filepath;

    Storage(String filepath){
        this.filepath = filepath;
    }

    ArrayList<Task> load() throws DukeException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new File(filepath));
            while (reader.hasNextLine()){
                Task task = Parser.parseTask(reader.nextLine());
                tasks.add(task);
            }
            reader.close();
            return tasks;
        } catch (FileNotFoundException e) {
            throw new DukeException("Oops! File not found.");
        }
    }
}
