package froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> list;

    public Lake(Integer... list) {
        this.setList(list);
    }

    public void setList(Integer... list) {
        this.list = Arrays.asList(list);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
    private final class Frog implements Iterator<Integer>{
        private int counter = 0;
        private boolean oddTurn = false;
        @Override
        public boolean hasNext() {
            if(list.size() > this.counter) {
                return true;
            }
                if(!oddTurn) {
                    this.counter = 0;
                    oddTurn = true;
                    return true;
                }
            return false;
        }

        @Override
        public Integer next() {
            if(this.counter % 2 == 0 && !oddTurn) {
                return list.get(this.counter++);
            } else if(this.counter % 2 != 0 && oddTurn) {
                return list.get(this.counter++);
            }
            this.counter++;
            return null;
        }
    }
}
