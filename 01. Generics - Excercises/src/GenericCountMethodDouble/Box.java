package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }
    public void add(T element){
        this.list.add(element);
    }
 //  public void swap(int firstIndex, int secondIndex) {

 //      T firstEl = list.get(firstIndex);
 //      T secondEl = list.get(secondIndex);
 //      T temp = firstEl;
 //      firstEl = secondEl;
 //      secondEl = temp;

 //      list.set(firstIndex, firstEl);
 //      list.set(secondIndex,secondEl);
 //  }
    public int compareTo(T element) {
        int counter = 0;
        for (int i = 0; i < this.list.size(); i++) {
            if (element.compareTo(this.list.get(i)) < 0) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        list.forEach(x -> builder.append("java.lang.Integer: ")
                .append(x).append(System.lineSeparator()));
        return builder.toString();
    }
}
