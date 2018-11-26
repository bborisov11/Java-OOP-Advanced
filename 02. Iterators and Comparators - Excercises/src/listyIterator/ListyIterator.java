package listyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private int index = 0;
    private List<String> list;

    public ListyIterator(String... list) {
        this.create(list);
    }

    public void create(String... list) {
        this.list = Arrays.asList(list);
    }
    public boolean move() {
        if(this.hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if(this.index < this.list.size() - 1) {
        return true;
        }
        return false;
    }
    public void print() {
        if(this.list.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.list.get(this.index));
    }
}
