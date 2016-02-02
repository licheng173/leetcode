class MyStack {
    Queue<Integer> qu = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        qu.add(x);
        for(int i = 0; i < qu.size() - 1; i++)
        {
            qu.add(qu.poll());
        }
    }

    // Removes the element on top of the stack.
    public int pop() {
        return qu.poll();
    }

    // Get the top element.
    public int top() {
        return qu.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return qu.isEmpty();
    }
}