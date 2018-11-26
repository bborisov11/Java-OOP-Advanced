package appenders;

import layouts.Layout;

public class FileAppender extends BaseAppender {
    File file;

    protected FileAppender(Layout layout) {
        super(layout);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void appendMessage(Layout layout) {
        this.file.write(layout.appendFormat(this.getDateTime(),this.getReportLevel(),
                this.getMessage()));
    }
}
