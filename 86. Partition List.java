    // 86. Partition List
    
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1), prehead = new ListNode(-1);
        ListNode last = dummy, cur = head, orilast = prehead;
        while(cur != null) {
            if(cur.val < x) {
                last.next = cur;
                last = cur;
                cur = cur.next;
                last.next = null;
            } else {
                orilast.next = cur;
                orilast = cur;
                cur = cur.next;
                orilast.next = null;
            }
        }
        last.next = prehead.next;
        return dummy.next;
    }
    