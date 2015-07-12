package com.github.ywind.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月7日 下午9:31:08
 * 类说明
 * 
 */
public class EdgeWeightedGraph {
	private List<Edge>[] adj;
	private int V;
	private int E;
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V){
		this.V=V;
		this.E=0;
		adj=(List<Edge>[])new List[V];
		for (List<Edge> list : adj) {
			list=new LinkedList<EdgeWeightedGraph.Edge>();
		}
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
	public void addEdge(Edge edge){
		int v=edge.v;
		int w=edge.w;
		adj[v].add(edge);
		adj[w].add(edge);
		E++;
	}
	
	class Edge implements Comparable<Edge>{
		private final int v;
		private final int w;
		private final double weight;
		
		public Edge(int v,int w,int weight) {
			this.v=v;
			this.w=w;
			this.weight=weight;
		}
		
		public int either() {
			return v;					
		}
		
		public int other(int v){
			if(v==this.v) return w;
			else if(v==this.w) return this.v;
			else throw new RuntimeException("Edge error");
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.weight>o.weight) return 1;
			else if(this.weight<o.weight) return -1;
			else return 0;
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E() {
		return E;
	}
	

}

