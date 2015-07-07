package com.github.ywind.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月7日 上午10:39:54
 * 类说明
 * 
 */
public class FS {
	
	public static void BFS(Graph graph,int s) {
		boolean[] marked=new boolean[graph.V()];
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.offer(s);
		marked[s]=true;
		while(!queue.isEmpty()){
			int v=queue.remove();
			for (int w : graph.adj(v)) {
				if(!marked[w]){
					queue.offer(w);
					marked[w]=true;
					System.out.println(w);
				}
			}
		}
	}
	
	public static void DFS(Graph graph,int s) {
		boolean[] marked=new boolean[graph.V()];
		Stack<Integer> stack=new Stack<Integer>();
		marked[s]=true;
		stack.push(s);
		while(!stack.isEmpty()){
			int v=stack.pop();
			for (int w : graph.adj(v)) {
				if(!marked[w]){
					stack.push(w);
					marked[w]=true;
					System.out.println(w);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph graph=new Graph(6);
		graph.addEdge(5,3);
		graph.addEdge(3,4);
		graph.addEdge(0,2);
		graph.addEdge(0,1);
		graph.addEdge(4,2);
		graph.addEdge(3,2);
		graph.addEdge(0,5);
		graph.addEdge(1,2);
		BFS(graph, 0);
		System.out.println();
		DFS(graph, 0);
	}
	
}
