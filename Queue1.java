import java.util.*;
import java.util.LinkedList;

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

  static class DequeB { // implement queue using deque
    Deque<Integer> deque = new LinkedList<>();

    public void add(int data) {
      deque.addLast(data);
    }

    public int remove() {
      return deque.removeFirst();
    }

    public int peek() {
      return deque.getFirst();
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

  public static void PrintFirstNonRepeating(String str) {// print first repeating element
    int[] freq = new int[26];

    java.util.Queue<Character> q = new LinkedList<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      q.add(ch);
      freq[ch - 'a']++;

      while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
        q.remove();
      }
      if (q.isEmpty()) {
        System.out.println(-1 + " ");
      } else {
        System.out.println(q.peek() + " ");
      }
    }
    System.out.println();
  }

  public static void interLeave(java.util.Queue<Integer> q) { // interLeave
    java.util.Queue<Integer> firsthalf = new LinkedList<>();
    int size = q.size();
    for (int i = 0; i < size / 2; i++) {
      firsthalf.add(q.remove());
    }
    while (!firsthalf.isEmpty()) {
      q.add(firsthalf.remove());
      q.add(q.remove());
    }
  }

  public static void reverseQueue(java.util.Queue<Integer> q) { // reverse queue
    Stack<Integer> s = new Stack<>();
    while (!q.isEmpty()) {
      s.push(q.remove());
    }
    while (!s.isEmpty()) {
      q.add(s.pop());
    }
  }

  public static void GenerateBinaryNo(int n) { // generate binary number of given string
    for (int i = 1; i <= n; i++) {
      String s = Integer.toBinaryString(i);
      System.out.println(s);
    }
    System.out.println();

  }

  public static void main(String[] args) {
    // java.util.Queue<Integer> q = new LinkedList<>();
    // q.add(1);
    // q.add(2);
    // q.add(3);

    // System.out.println(q.peek());
    // System.out.println(q.remove());
    // System.out.println(q.remove());
    // System.out.println(q.remove());
    GenerateBinaryNo(5);

  }
}
