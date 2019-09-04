import java.util.Date;

public class Deadline extends Task {

    private String by;
    private Date datetime;

    Deadline(int status, String description, String by) {
        super(description);
        this.by = by;
        if(status == 1) super.markAsDone();
        this.datetime = Parser.setDatetime(by);
    }

    Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.datetime = Parser.setDatetime(by);
    }

    @Override
    public String toFile() {
        return "D " + super.toFile() + "|" + by;
    }

    @Override
    public String toString() {
        return "    [D]" + super.toString() + " (by: " + by + ")";
    }
}