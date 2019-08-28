public class Task {
    protected String description;
    protected boolean isDone;
//    protected char type;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
//        this.type = 'X';
    }

    public String getStatusIcon() {
        return (isDone ? "✓" : "✗"); //return tick or X symbols
    }
//
//    public char getType(){
//        return this.type;
//    }
//
//    public void setType(char c){
//        this.type = c;
//    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String toString(){
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}