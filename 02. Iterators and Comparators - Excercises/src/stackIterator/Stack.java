package stackIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Stack<Integer> implements Iterable<Integer>{
    private List<Integer> list;

    public Stack(String... list) {
        this.list = new ArrayList<>();
    }

    public void push(Integer... elemenet) {
        Collections.addAll(list, elemenet);
    }
    public void pop() {
        if(list.size() == 0) {
            throw new IllegalArgumentException("No elements");
        }
        list.remove(list.get(list.size() - 1));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }
    private final class StackIterator implements Iterator<Integer> {
        private int counter = list.size() - 1;
        @Override
        public boolean hasNext() {
            if(counter >= 0) {
                return true;
            }
            return false;
        }

        @Override
        public Integer next() {
                return list.get(counter--);
        }
    }
}
