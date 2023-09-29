
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function

class MinStack {
    Node head;

    public MinStack(){
    }
    
    public void push(int x) {
        if (head == null){
            head = new Node(x, x, null);
        }
        else {head = new Node(x, Math.min(x, head.min), head);}
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

class Node{
    int min;
    int val;
    Node next;

    Node(int val, int min, Node next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
