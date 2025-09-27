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

  static class QueueLL { // Implmenting queue using LinkedList pblm 
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

  static class DequeB { // implement queue using deque pblm 
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

  static class Queue { // Implementing queue using array pblm 
    static int[] arr;
    static int size;
    static int rear;

    Queue(int n) {
      arr = new int[n];
      size = n;
      rear = -1;
    }

    public static boolean isEmpty() {    // is Empty
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

  static class CQueue { // implementing circular queue using array pblm 
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

  public static int minCost(int[] arr, int n) { // minimum cost to find n ropes
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      pq.add(arr[i]);
    }
    int res = 0;
    while (pq.size() > 1) {
      int first = pq.poll();
      int second = pq.poll();
      res += first + second;

      pq.add(first + second);
    }
    return res;
  }

  public static java.util.Queue<Integer> reverseTheFirstKElement(java.util.Queue<Integer> q, int k) { // reverse k elements
    if (q == null || k <= 0 || k >= q.size()) {
      return q;
    }
    Stack<Integer> s = new Stack<>();

    for (int i = 0; i < k; i++) {
      s.push(q.remove());
    }

    while (!s.isEmpty()) {
      q.add(s.pop());
    }
    int size = q.size();
    for (int i = 0; i < size - k; i++) {
      q.add(q.poll());
    }
    return q;
  }

  

  public static void main(String[] args) {
      java.util.Queue<Integer>q = new LinkedList<>();
      q.add(10);
      q.add(20);
      q.add(30);
      q.add(40);
      q.add(50);
      q.add(60);
      q.add(70);
      q.add(80);

     reverseTheFirstKElement(q, 3);
     while(!q.isEmpty()){
      System.out.println(q.remove() + "");
     }
     System.out.println();

    

  }
}
