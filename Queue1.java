import java.util.*;


public class Queue1 {
  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;

    }
  }

  static class QueueLL { // Implmenting queue using LinkedList
    static Node head = null;
    static Node tail = null;

    public static boolean isEmpty() {
      return head == null && tail == null;
    }

    public static void add(int data) {
      Node newNode = new Node(data);
      if (head == null) {
        head = tail = newNode;
        return;
      }
      tail.next = newNode;
      tail = newNode;
    }

    public static int remove() {
      if (isEmpty()) {
        System.out.println("empty queue");
        return -1;
      }
      int front = head.data;
      if (tail == head) {
        tail = head = null;
      } else {
        head = head.next;
      }
      return front;
    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("empty queue");
        return -1;
      }
      return head.data;
    }
  }

  static class Queue { // Implementing queue using array
    static int[] arr;
    static int size;
    static int rear;

    Queue(int n) {
      arr = new int[n];
      size = n;
      rear = -1;
    }

    public static boolean isEmpty() {
      return rear == -1;
    }

    public static void add(int data) {
      if (rear == size - 1) {
        System.out.println("queue is full");
        return;
      }
      rear = rear + 1;
      arr[rear] = data;
    }

    public static int remove() {
      if (isEmpty()) {
        System.out.println("empty queue");
        return -1;
      }
      int front = arr[0];
      for (int i = 0; i < rear; i++) {
        arr[i] = arr[i + 1];
      }
      rear = rear - 1;
      return front;
    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("empty queue");
        return -1;
      }
      return arr[0];
    }
  }

  static class CQueue { // implementing circular queue using array
    static int[] arr;
    static int size;
    static int rear;
    static int front;

    CQueue(int n) {
      arr = new int[n];
      size = n;
      rear = -1;
      front = -1;
    }

    public static boolean isEmpty() {
      return rear == -1 && front == -1;
    }

    public static boolean isFull() {
      return (rear + 1) % size == front;
    }

    public static void add(int data) {
      if (isFull()) {
        System.out.println("queue is full");
        return;
      }

      if (front == -1) {
        front = 0;
      }

      rear = (rear + 1) % size;
      arr[rear] = data;
    }

    public static int remove() {
      if (isEmpty()) {
        System.out.println("empty queue");
        return -1;
      }
      int result = arr[front];
      if (rear == front) {
        rear = front = -1;
      } else {
        front = (front + 1) % size;
      }
      return result;
    }

    public static int peek() {
      if (isEmpty()) {
        System.out.println("empty queue");
        return -1;
      }
      return arr[front];
    }
  }

   

 
  public static void main(String[] args) {
    Queue q = new Queue(5);
    q.add(1);
    q.add(2);
    q.add(3);

    while (!q.isEmpty()) {
      System.out.println(q.peek());
      q.remove();
    }
  }
}
