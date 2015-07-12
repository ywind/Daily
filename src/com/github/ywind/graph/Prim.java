package com.github.ywind.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.print.attribute.standard.PDLOverrideSupported;

import com.github.ywind.graph.EdgeWeightedGraph;
import com.github.ywind.graph.EdgeWeightedGraph.Edge;
import com.sun.org.apache.bcel.internal.classfile.Visitor;
/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月7日 下午9:20:15
 * 类说明
 * 
 * Prim 最小生成树算法
 * 
 */
public class Prim {
	private boolean[] marked;
	private Queue<Edge> mst;
	private Queue<Edge> pq;
	
	public Prim(EdgeWeightedGraph G){
		pq=new PriorityQueue<Edge>();
		marked=new boolean[G.V()];
		mst=new LinkedList<Edge>();
		visit(G,0);
		while(!pq.isEmpty()){
			Edge e=pq.poll();
			int v=e.either();
			int w=e.other(v);
			if(marked[v]&&marked[w]) continue;
			mst.add(e);
			if(!marked[v]) visit(G, v);
			if(!marked[w]) visit(G, w);
		}
		
	}

	private void visit(EdgeWeightedGraph g, int i) {
		// TODO Auto-generated method stub
		marked[i]=true;
		for(Edge e:g.adj(i))
			if(marked[e.other(i)]) pq.add(e);
	}
	
}
