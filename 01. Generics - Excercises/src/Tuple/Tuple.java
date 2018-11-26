package Tuple;

public class Tuple<T,E> {
    private T firstElement;
    private E secondElement;

    public Tuple(T firstElement, E secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public T getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(T firstElement) {
        this.firstElement = firstElement;
    }

    public E getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(E secondElement) {
        this.secondElement = secondElement;
    }

    @Override
    public String toString() {
        return this.firstElement + " -> " + this.secondElement;
    }
}
