package layouts;

public class SimpleLayout implements Layout {
    @Override
    public String appendFormat(String dateTime, String reportLevel, String message) {
        return String.format("<%s> - <%s> - <%s>",dateTime,reportLevel, message);
    }
}
