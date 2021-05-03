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

    public void insertAtBeginning(T new_data) {
        Node<T> new_node = new Node<>(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void insertAtEnd(T new_data) {
        Node<T> new_node = new Node<>(new_data);
        if (head == null) {
            head = new Node<T>(new_data);
            return;
        }
        new_node.next = null;
        Node<T> last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
    }

    public void insertAfter(Node<T> prev_node, T new_data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node<T> new_node = new Node<>(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
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
