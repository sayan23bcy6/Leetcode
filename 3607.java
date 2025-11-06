class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer>[] adj = (List<Integer>[]) new ArrayList[c + 1];
        for (int i = 1; i <= c; i++) adj[i] = new ArrayList<>();

        for (int[] conn : connections) {
            int a = conn[0], b = conn[1];
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] comp = new int[c + 1];
        Arrays.fill(comp, -1);
        int compCount = 0;
        for (int i = 1; i <= c; i++) {
            if (comp[i] == -1) {
                dfs(i, compCount++, adj, comp);
            }
        }
        PriorityQueue<Integer>[] compPQ = (PriorityQueue<Integer>[]) new PriorityQueue[compCount];
        for (int i = 0; i < compCount; i++) compPQ[i] = new PriorityQueue<>();

        int[] active = new int[c + 1];
        Arrays.fill(active, 1);

        for (int i = 1; i <= c; i++) {
            compPQ[comp[i]].add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], node = q[1];
            int compId = comp[node];

            if (type == 1) {
                if (active[node] == 1) {
                    ans.add(node);
                } else {
                    while (!compPQ[compId].isEmpty() && active[compPQ[compId].peek()] == 0)
                        compPQ[compId].poll();

                    if (compPQ[compId].isEmpty())
                        ans.add(-1);
                    else
                        ans.add(compPQ[compId].peek());
                }
            } else if (type == 2) {
                active[node] = 0;
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int node, int compId, List<Integer>[] adj, int[] comp) {
        Stack<Integer> st = new Stack<>();
        st.push(node);
        comp[node] = compId;

        while (!st.isEmpty()) {
            int u = st.pop();
            for (int v : adj[u]) {
                if (comp[v] == -1) {
                    comp[v] = compId;
                    st.push(v);
                }
            }
        }
    }
}
