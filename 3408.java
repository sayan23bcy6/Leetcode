class TaskManager {
    private Map<Integer, int[]> map;             
    private PriorityQueue<int[]> pq;
    public TaskManager(List<List<Integer>> tasks) {
        map=new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];    
            return b[1] - a[1];                      
        });
        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            map.put(taskId, new int[]{userId, priority});
            pq.offer(new int[]{priority, taskId});
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        map.put(taskId,new int[]{userId,priority});
        pq.offer(new int[]{priority,taskId});
    }
    
    public void edit(int taskId, int newPriority) {
        int userId=map.get(taskId)[0];
        map.put(taskId,new int[]{userId,newPriority});
        pq.offer(new int[]{newPriority,taskId});
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty())
        {
            int top[]=pq.poll();
            int priority=top[0];
            int taskId=top[1];
            if(!map.containsKey(taskId))
            continue;
            if(map.get(taskId)[1]!=priority)
            continue;
            int val=map.get(taskId)[0];
            map.remove(taskId);
            return val;
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */