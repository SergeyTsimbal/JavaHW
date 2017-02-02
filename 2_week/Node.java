//Задание 7
//Реализовать метод который будет принимать Node node (ссылка на первый элемент списка) и возвращать список в обратном порядке.
public class Node {
    static Node node;
    int element;
    Node next;

    public Node(int element) {
        this.element = element;
    }

    void printList(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.printList(node);

    }
}