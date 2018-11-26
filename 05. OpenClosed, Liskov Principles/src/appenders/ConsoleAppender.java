package appenders;

import layouts.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void appendMessage(Layout layout) {
        System.out.println(layout.appendFormat(this.getDateTime(),this.getReportLevel(),
                this.getMessage()));
    }
}
