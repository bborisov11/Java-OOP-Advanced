package CustomListSorter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable {
    protected List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }
    public void remove(int index) {
        this.list.remove(index);
    }
    public boolean contains(T element) {
        if(this.list.contains(element)) {
            return true;
        }
        return false;
    }
    public void swap(int firstIndex, int secondIndex) {
        T firstEl = this.list.get(firstIndex);
        T secondEl = this.list.get(secondIndex);
        T temp = firstEl;
        firstEl = secondEl;
        secondEl = temp;

        this.list.set(firstIndex, firstEl);
        this.list.set(secondIndex,secondEl);
    }
    public int countGreaterThat(T element) {
        int counter = 0;
        for (int i = 0; i < this.list.size(); i++) {
            if (element.compareTo(this.list.get(i)) < 0) {
                counter++;
            }
        }
        return counter;
    }
    public T getMax() {
        T maxElement = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (maxElement.compareTo(this.list.get(i)) < 0) {
                maxElement = this.list.get(i);
            }
        }
        return maxElement;
    }
    public T getMin() {
        T minElement = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (minElement.compareTo(this.list.get(i)) > 0) {
                minElement = this.list.get(i);
            }
        }
        return minElement;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        list.forEach(x -> builder.append(x).append(System.lineSeparator()));
        return builder.toString();
    }



    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
