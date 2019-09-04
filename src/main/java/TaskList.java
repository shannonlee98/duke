import java.util.ArrayList;

class TaskList {

    ArrayList<Task> taskList;

    TaskList(ArrayList<Task> list) {
        this.taskList = list;
    }

    TaskList() {
        this.taskList = new ArrayList<>();
    }

    int indexOf(Task entry) {
        return this.taskList.indexOf(entry) + 1;
    }

    int size() {
        return this.taskList.size();
    }

    Task get(int taskNumber) { return this.taskList.get(taskNumber);
    }

    void remove(int taskNumber) { this.taskList.remove(taskNumber);
    }

    void add(Task task) { this.taskList.add(task);
    }
}
