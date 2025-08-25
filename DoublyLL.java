public class DoublyLL {

    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { // add first node of the doubly ll
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public int RemoveFirst() { // remove first node from ll  
        if (head == null) {
            System.out.println("Dll is empty");
            return -1;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void addLast(int data) {    // add node to last
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = null;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        tail = newNode;
    }

    public int RemoveLast() {   // remove last node from ll 
        if (head == null) {
            System.out.println("Dll is empty");
            return -1;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;

    }

    public void Reversedll() { // reverse dll
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;

        }
        head = prev;
    }


 
    public void Print() { // print doubly linked list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.Print();
        dll.Reversedll();
        dll.Print();
        System.out.println(dll.size);
    }
}
