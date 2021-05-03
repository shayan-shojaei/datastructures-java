package implementations;

public class MyStack<E> {
    private StackNode<E> root;

    static class StackNode<T> {
        T data;
        StackNode<T> next;

        StackNode(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void push(E data) {
        StackNode<E> newNode = new StackNode<>(data);

        if (root == null) {
            root = newNode;
        } else {
            StackNode<E> temp = root;
            root = newNode;
            newNode.next = temp;
        }
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        Object popped = null;
        if (root == null) {
            System.out.println("Stack is Empty");
        } else {
            popped = root.data;
            root = root.next;
        }
        return (E) popped;
    }

    public E peek() {
        if (root == null) {
            // Stack is empty
            return null;
        } else {
            return root.data;
        }
    }
}
