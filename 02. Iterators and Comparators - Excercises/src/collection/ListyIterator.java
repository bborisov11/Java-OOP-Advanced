package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable{
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

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    public void printAll() {
        if(this.list.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        StringBuilder builder = new StringBuilder();
        ListIterator iter = new ListIterator();
        while(iter.hasNext()) {
            builder.append(iter.next()).append(" ");
        }
        System.out.println(builder);
    }

    private final class ListIterator implements Iterator<String> {
            private int counter = 0;
            @Override
            public boolean hasNext() {
                if(this.counter < list.size()) {
                    return true;
                }
                return false;
            }

            @Override
            public String next() {
                return list.get(counter++);
            }
        }
}
