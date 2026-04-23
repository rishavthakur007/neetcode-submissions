class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] arr: edges){
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        boolean[] vis = new boolean[n];
        if(!dfs(0,adjList,-1,vis)){
            return false;
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;

    }

    public boolean dfs(int node, List<List<Integer>> adjList,int parent,boolean[] vis){
        vis[node] = true;
        for(int child:adjList.get(node)){
            if(vis[child] && child!=parent){
                return false;
            }
            else if(!vis[child] && !dfs(child,adjList,node,vis)){
                return false;
            }
        }
        return true;
    }
}
