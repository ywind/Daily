package com.github.ywind.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月7日 上午10:40:14
 * 类说明
 * 
 */
public class Graph {
	private int V;//顶点
	private int E;//边
	private List<Integer>[] adj;//邻接表
	
	@SuppressWarnings("unchecked")
	public Graph(int V){
		this.V=V;
		adj=(List<Integer>[])new List[V];
		for(int v=0;v<V;v++){
			adj[v]=new LinkedList<Integer>();
		}
	}
	public int V(){
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
}
