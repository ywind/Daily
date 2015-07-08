package com.github.ywind.graph;

import java.util.Stack;

/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月7日 下午8:57:36
 * 
 * 该类是寻找有向环
 * 
 * 拓扑排序是逆后序排序（使用栈，在递归的时候后序压入）
 * 
 * Kosaraju算法计算强连通分量，按照反向图的逆后序顺序深度优先遍历图
 * 
 */
public class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	public DirectedCycle(DiGraph G){
		onStack=new boolean[G.V()];
		edgeTo=new int[G.V()];
		marked=new boolean[G.V()];
		for(int v=0;v<G.V();v++)
			if(!marked[v]) dfs(G,v);
	}
	private void dfs(DiGraph g, int v) {
		onStack[v]=true;
		marked[v]=true;
		for(int w:g.adj(v))	{
			if(cycle!=null) return;
			if(!marked[w]){
				edgeTo[w]=v;
				dfs(g, w);
			}else if(onStack[w]){
				cycle=new Stack<Integer>();
				for(int x=v;x!=w;x=edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(v);
			}
			
		}
			
		onStack[v]=false;
		
	}
	
}
