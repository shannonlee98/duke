import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task {

    private String at;
    private Date datetime;

    Event(int status, String description, String at) {
        super(description) ;
        this.at = at;
        if(status == 1) super.markAsDone();
        this.datetime = setDatetime(this.at);
    }

    Event(String description, String at) {
        super(description);
        this.at = at;
        this.datetime = setDatetime(at);
    }

    private Date setDatetime(String by) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(by);
        } catch (ParseException e) {
            return null;
        }
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
