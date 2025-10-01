import java.util.*;
import java.util.Queue;
import java.util.LinkedList;


public class StackB {

     

    static class InnerQueue { // implement stack using two queue
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            }

            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }

    }

     static class DequeB{ // implement stack using deque

        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }

     }


    static class StackArrayList { //implementing using arraylist
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);

        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    static class Node { // implementing using LinkedList
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    static class MyLL {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;

        }
    }

    public static void pushAtBottom(Stack<Integer> s, int data) { // push at the bottom pblm 
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str) { //reverse string  pblm 
        Stack<Character> s = new Stack<>();
        int idx = 0;

        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) { // reverse the stack element pblm 
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int[] stocks, int[] span) { // stock span pblm 
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void NextGreaterElement(int[] arr, Stack<Integer> s, int[] nextGreater) { // find the next greater element pblm
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();

    }

    public static boolean ValidParentheses(String str) { // valid parentheses pblm 
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean DuplicateParentheses(String str) {// duplicate parentheses
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    s.pop();
                }
            } else {
                s.push(ch);
            }
        }
        return false;

    }

    public static void LargestRectangleInHistogram(int[] arr) { // O(n) largest area of histogram 
        int maxArea = 0;
        int[] nsr = new int[arr.length];
        int[] nsl = new int[arr.length];

        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("maximum area in histogram:  " + maxArea);

    }

    public static int TrappingRainWater(int[] height) { // trapping rainwater pblm 
        Stack<Integer> stack = new Stack<>();
        int n = height.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (height[stack.peek()] < height[i])) {
                int pop_height = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;

                ans += distance * min_height;

            }
            stack.push(i);

        }
        return ans;
    }

    public static void main(String[] args) {
        
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
       
        System.out.println(s.peek());

       System.out.println(s.pop());
       System.out.println(s.pop());
       System.out.println(s.pop());


    }
}
