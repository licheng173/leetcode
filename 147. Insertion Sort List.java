    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = new ListNode(-1);
        p.next = null;
        ListNode m = head;
        while(m != null)
        {
            ListNode tm = m.next;
            ListNode n = p;
            ListNode l = p.next;
            while(l != null && l.val < m.val )
            {
                l = l.next;
                n = n.next;
            }
            m.next = n.next;
            n.next = m;
            m = tm;
        }
        return p.next;
    }