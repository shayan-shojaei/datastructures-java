package implementations;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    class Node<E> {
        E data;
        Node<E> next;

        public Node() {
            this(null);
        }

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public MyQueue() {
        front = rear = new Node<T>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        rear.next = newNode;
        rear = newNode; /* make rear point at last node */
        size++;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        Node<T> destroy = front.next;
        T retValue = destroy.data;
        front.next = front.next.next;
        destroy = null; /* clear let GC do it's work */
        size--;

        if (isEmpty()) {
            front = rear;
        }

        return retValue;
    }

    public T peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return front.next.data;
    }

    public T peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return rear.data;
    }

    public int size() {
        return size;
    }

}