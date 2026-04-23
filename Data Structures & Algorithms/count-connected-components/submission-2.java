class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                vis[i] = true;
                dfs(i,adjList,vis);
                count++;
            }
        }
            

        return count;

    }
    

    public void dfs(int node, List<List<Integer>> adjList,boolean[] vis){
        
        for(int child:adjList.get(node)){
            if(!vis[child]){
                vis[child] = true;
                dfs(child,adjList,vis);
            }
        }
        
    }
}
