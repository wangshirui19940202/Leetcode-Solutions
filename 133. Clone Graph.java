// 133. Clone Graph

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        return dfs(node, new HashMap(), new HashSet());
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map, HashSet<Integer> visit) {
        if (visit.contains(node.label)) return map.get(node.label);
        visit.add(node.label);
        UndirectedGraphNode cur = new UndirectedGraphNode(node.label);
        map.put(cur.label, cur);
        for (UndirectedGraphNode next : node.neighbors) {
            if (map.containsKey(next.label)) cur.neighbors.add(map.get(next.label));
            else cur.neighbors.add(dfs(next, map, visit));            
        }
        return cur;
    }
    
    /*
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
    */
}