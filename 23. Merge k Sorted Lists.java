    // 23. Merge k Sorted Lists

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> (a.val - b.val));
        for (ListNode n : lists) if (n != null) pq.add(n);
        ListNode dummy = new ListNode(-1), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.remove();
            if (cur.next != null) pq.add(cur.next);
            tail.next = cur;
            tail = tail.next;
            cur.next = null;
        }
        
        return dummy.next;
    }
    
    /*
    // merge sort
    public ListNode mergeKLists(ListNode[] lists) {
        int size=lists.length;
        ListNode dummy=new ListNode(0);
        if(size==0) return dummy.next;
        int i=size-1;
        int l=0,h=i;
        while(l<h){
            for(i=0;l+i<h-i;i++){
                lists[l+i]=merge(lists[l+i],lists[h-i]);
            }
            h=l+i==h-i?i:i-1;
            l=0; 
        }
        return lists[0];
    }
    
    private ListNode merge(ListNode n1,ListNode n2){
        
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        ListNode h1=n1;
        ListNode h2=n2;
        while(h1!=null&&h2!=null){
            if(h1.val<h2.val) {
                cur.next=h1;
                h1=h1.next;
                cur=cur.next;
                cur.next=null;
            } else if(h1.val>=h2.val) {
                cur.next=h2;
                h2=h2.next;
                cur=cur.next;
                cur.next=null;
            }
        }
        if(h1!=null) cur.next=h1;
        if(h2!=null) {cur.next=h2;}
        return dummy.next;
    }
    */