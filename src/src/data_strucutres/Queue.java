import java.util.ArrayList;

public class Queue<T> {

    private ArrayList<T> queue = new ArrayList<>();

    public Queue() {
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.remove(0);
    }

    public T front() {
        return queue.get(0);
    }

    public boolean isEmpty() {
        return (queue.size() == 0) ? true : false;
    }

}
