package appenders;

import layouts.Layout;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private String dateTime;
    private String reportLevel;
    private String message;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
    }

    protected Layout getLayout() {
        return layout;
    }

    protected String getDateTime() {
        return dateTime;
    }

    protected String getMessage() {
        return message;
    }

    protected String getReportLevel() {
        return reportLevel;
    }
}
