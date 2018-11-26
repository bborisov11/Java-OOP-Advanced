package logger;

import appenders.File;

public class LogFile implements File {

    int size;
    StringBuilder builder;

    public LogFile() {
        this.builder = new StringBuilder();
    }

    public int getSize() {
        return size;
    }

    @Override
    public void write(String message) {
        this.size += this.getCharSize(message);
            this.builder.append(message);
    }

    public int getCharSize(String message) {
        return message.chars().filter(Character::isAlphabetic).sum();
    }

}
