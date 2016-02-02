class MinStack {
    private Stack<Integer> mstack = new Stack<Integer>();
    private int minNum = Integer.MAX_VALUE;
    private int[] arr = new int[1];
    private int N = 0;
    
    public void push(int x) {
        if(N >= arr.length)
        {
            int[] newArr = new int[N*2];
            for(int i = 0; i < N; i++)
            {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        if(x <= minNum) 
        {
            minNum = x;
            mstack.push(x);
        }
        arr[N++]=x;
    }

    public int pop() {
        if(arr[--N] == mstack.peek()) mstack.pop();
        if(!mstack.empty())
        minNum = mstack.peek();
        else 
        minNum = Integer.MAX_VALUE;
        return arr[N];
        
    }

    public int top() {
        int n = N;
        return arr[n - 1];
    }

    public int getMin() {
        return mstack.peek();
    }
}

//one stack;
public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;//If negative, increase the min value

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}