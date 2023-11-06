import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public Stack() {
    }

    public void push(T item) {
        stack.add(item);
    }

    public T dequeue() {
        return stack.remove(stack.size()-1);
    }

    public T top() {
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty() {
        return (stack.size() == 0) ? true : false;
    }

    public int getSize() {
        return stack.size();
    }
}
