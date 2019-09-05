import java.util.Date;

public class Event extends Task {

    private String at;
    private Date datetime;

    Event(int status, String description, String at) {
        super(description) ;
        this.at = at;
        if(status == 1) super.markAsDone();
        this.datetime = Parser.setDatetime(at);
    }

    Event(String description, String at) {
        super(description);
        this.at = at;
        this.datetime = Parser.setDatetime(at);
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
