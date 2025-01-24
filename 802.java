class Solution {
    public boolean dfs(int node,int[][] graph,int[] state)
    {
        if(state[node]!=0)
        return state[node]==2;
        state[node]=1;
        for(int neighbour:graph[node])
        {
            if(!dfs(neighbour,graph,state))
            return false;
        }
        state[node]=2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int state[]=new int[graph.length];
        ArrayList<Integer> safe= new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(dfs(i,graph,state))
            safe.add(i);
        }
        return safe;
    }
}