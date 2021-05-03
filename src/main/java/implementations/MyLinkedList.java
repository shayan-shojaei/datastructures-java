package implementations;

public class MyLinkedList<T> {
    private Node<T> head;

    static class Node<E> {
        E key;
        Node<E> next;

        public Node(E data) {
            key = data;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(T newData) {
        Node<T> newNode = new Node<>(newData);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(T newData) {
        Node<T> newNode = new Node<>(newData);
        if (head == null) {
            head = new Node<T>(newData);
            return;
        }
        newNode.next = null;
        Node<T> last = head;
        while (last.next != null)
            last = last.next;
        last.next = newNode;
    }

    public void insertAfter(Node<T> prev_node, T newData) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node<T> newNode = new Node<>(newData);
        newNode.next = prev_node.next;
        prev_node.next = newNode;
    }

    public Node<T> search(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.key == key) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
