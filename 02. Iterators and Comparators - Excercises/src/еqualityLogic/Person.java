package еqualityLogic;

import java.util.Comparator;

public class Person implements Comparator<Person>{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.name.compareTo(o2.name) == 0 && o1.age == o2.age) {
                return 0;
        } else {
            if(o1.name.compareTo(o2.name) == 0) {
                return o1.age - o2.age;
            }
            else {
                return o1.name.compareTo(o2.name);
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
