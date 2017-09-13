    // 133. Clone Graph

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap();
        map.put(node.label, new UndirectedGraphNode(node.label));
        
        Queue<UndirectedGraphNode> queue = new LinkedList();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode old = queue.poll();
            UndirectedGraphNode newnode = map.get(old.label);
            for(UndirectedGraphNode n : old.neighbors) {
                if(!map.containsKey(n.label)) {
                    map.put(n.label, new UndirectedGraphNode(n.label));
                    queue.add(n);
                }
                UndirectedGraphNode cur = map.get(n.label);
                newnode.neighbors.add(cur);
            }
        }
        return map.get(node.label);
    } 