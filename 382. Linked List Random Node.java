public class Solution {
    private int length;
    private Random random;
    private ListNode head;
    
    //public Solution() {
        
    //}
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        int count = 0;
        this.head = head;
        while(head != null) {
            count++;
            head = head.next;
        }
        length = count;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int index = random.nextInt(length) + 1;
        //ListNode newHead = new ListNode(1);
        //newHead.next = head;
        ListNode start = head;
        while(index > 1) {
            start = start.next;
            index--;
        }
        //length--;
        return start.val; 
        
    }
}


//
public class Solution {

    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    ListNode head = null;
    Random randomGenerator = null;
    public Solution(ListNode head) {
        this.head = head;
        this.randomGenerator = new Random();

    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode result = null;
        ListNode current = head;
        
        for(int n = 1; current!=null; n++) {
            if (randomGenerator.nextInt(n) == 0) {
                result = current;
            }
            current = current.next;
        }
        
        return result.val;
        
    }
}
