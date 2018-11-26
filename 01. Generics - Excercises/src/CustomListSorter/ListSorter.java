package CustomListSorter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorter extends CustomList{

    public static <T extends Comparable<T>> void sort(CustomList list) {
        Collections.sort(list.list);
    }
}
