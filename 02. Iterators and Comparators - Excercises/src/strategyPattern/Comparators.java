package strategyPattern;

import java.util.Comparator;

public class Comparators {

    public static Comparator<Person> nameLengthAndLetter = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            if(o1.getName().length() == o2.getName().length()) {
                if(o1.getName().toLowerCase().charAt(0) == o2.getName().toLowerCase().charAt(0)) {
                    return 0;
                }
                return o1.getName().toLowerCase().charAt(0) - o2.getName().toLowerCase().charAt(0);
            }
            else {
                return o1.getName().length() - o2.getName().length();
            }
        }
    };

    public static Comparator<Person> ageComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }
    };

}
