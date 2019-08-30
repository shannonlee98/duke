import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    protected String by;
    protected Date datetime;

    public Deadline(int status, String description, String by) {
        super(description);
        this.by = by.trim();
        if(status == 1) super.markAsDone();
        this.datetime = setDatetime(this.by);
    }

    public Date setDatetime(String by) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.parse(by);
        } catch (ParseException e) {
            return null;
        }
    }

//    public String getBy() {
//        return this.by;
//    }

    @Override
    public String toFile() {
        return "D " + super.toFile() + "|" + by;
    }

    @Override
    public String toString() {
        return "    [D]" + super.toString() + " (by: " + by + ")";
    }
}