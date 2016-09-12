    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode insertHead = new ListNode(-1);
        insertHead.next = null;
        ListNode current = head;
        while(current != null)
        {
            ListNode tmp = current.next;
            ListNode pre = insertHead;
            while(pre.next != null && pre.next.val < current.val )
            {
                pre = pre.next;
            }
            current.next = pre.next;
            pre.next = current;
            current = tmp;
        }
        return insertHead.next;
    }