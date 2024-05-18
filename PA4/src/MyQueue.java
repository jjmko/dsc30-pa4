/*
    Name: Josef Ongchangco
    PID:  A17751436
 */

/**
 * PA 4 MyQueue
 *
 * @author Josef Ongchangco
 * @since 04/29/2024
 */
import java.util.NoSuchElementException;

public class MyQueue<T> {

    private DoublyLinkedList<T> elements;

    public MyQueue() {
        this.elements = new DoublyLinkedList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public void enqueue(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        elements.add(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elements.getLast();
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}