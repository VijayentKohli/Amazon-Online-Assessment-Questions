package com.iamvkohli.AMAZON.OA;
import java.util.*;

public class CriticalRouters {

	int time = 0;

	private  List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
		
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int i=0;i<numRouters;i++) {
			map.put(i+1, new HashSet<>());
		}
		for(int[] link : links) {
			map.get(link[0]).add(link[1]);
			map.get(link[1]).add(link[0]);
		}
		Set<Integer> set = new HashSet<>();
		int[] low = new int[numRouters];
		int[] ids = new int[numRouters];
		int parent[] = new int[numRouters]; 
		Arrays.fill(ids, -1);
		Arrays.fill(parent, -1);
		for(int i=1;i<=numRouters;i++) {
			if(ids[i-1] == -1)
				dfs(map, low, ids, parent, i, set);
		}
		return new ArrayList<>(set);
	}



	private  void dfs(Map<Integer, Set<Integer>> map, int[] low, int[] ids, int[] parent, int cur, Set<Integer> res) {
		int children = 0; 
		++time;
		ids[cur-1] = time;
		low[cur-1]=  time;
		for(int nei : map.get(cur)) {
			if(ids[nei-1] == -1) {
				children++;
				parent[nei-1] = cur;
				dfs(map, low, ids, parent,nei, res);
				low[cur-1] = Math.min(low[cur-1], low[nei-1]);
				if((parent[cur-1] == -1 && children > 1) || (parent[cur-1] != -1 && low[nei-1] >= ids[cur-1]))
					res.add(cur);
			}
			else if(nei != parent[cur-1])
				low[cur-1] = Math.min(low[cur-1], ids[nei-1]);
		}
	}
	
	public static void main(String[] args) {
		int numRouters = 6;
		int numEdges = 5;
		int[][] grid = {{1,2},{2,3},{3,4}, {4,5},{6,3}};
		CriticalRouters inst1 = new CriticalRouters();
		ArrayList<Integer> result = (ArrayList<Integer>) inst1.getCriticalNodes(grid, numEdges, numRouters);
		System.out.print(result);
		
	}

}