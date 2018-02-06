/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        //corner cases
        if (root == null) {
            return null;
        }
        
        //do bfs
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(root);
        map.put(root, new UndirectedGraphNode(root.label));
        
        while (!q.isEmpty()) {
            UndirectedGraphNode node = q.poll();
            for (int i = 0; i < node.neighbors.size(); i++) {
                UndirectedGraphNode tmp = node.neighbors.get(i);
                if (!map.containsKey(tmp)) {
                    map.put(tmp, new UndirectedGraphNode(tmp.label));
                    q.add(tmp);
                }
                map.get(node).neighbors.add(map.get(tmp));
            }
        }
        
        return map.get(root);
    }
}
