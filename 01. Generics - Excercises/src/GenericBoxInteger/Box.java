package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }
    public void add(T element){
        this.list.add(element);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        list.forEach(x -> builder.append("java.lang.String: ")
                .append(x).append(System.lineSeparator()));
        return builder.toString();
    }
}
