package by.gsu.pms.idz_8_xml;

public class Note {
    String to;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    String from;
    String heading;
    String body;

    public void reveal() {
        System.out.println("Here is the message from "+this.from + " for you, " + this.to);
        System.out.println("Theme:" + this.heading);
        System.out.println("Message:" + this.body);

    }
}
