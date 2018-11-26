package appenders;

import layouts.Layout;

public interface Appender {
    void appendMessage(Layout layout);
}
