public class Event extends Task {

    protected String at;

    public Event(String description, String at){
        super(description);
        this.at = at;
    }

    public Event(int status, String description, String at) {
        super(description) ;
        this.at = at;
        if(status == 1) super.markAsDone();
    }

    @Override
    public String toFile() {
        return "E " + super.toFile() + "|" + at;
    }

    @Override
    public String toString() {
        return "    [E]" + super.toString() + " (at: " + at + ")";
    }
}
