package com.github.ywind.select;

import java.util.Stack;

/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月6日 下午9:10:02
 * 
 * 二叉查找树
 * 
 */
public class BinaryTree {
	private class Node{
		private int key;
		private Node left;
		private Node right;
		private int N;
		public Node(int key,int N){
			this.key=key;
			this.N=N;
		}
	}
	
	private Node root;
	
	public int size(Node x){
		if(x==null)return 0;
		return x.N;
	}
	/*
	 * 用的显式栈，非递归，没仔细检查，不太优雅
	 */
	public void put(int key){
		if(root==null) {
			root=new Node(key,1);
		}else{
			Node x=root;
			Node y;
			boolean found=false;
			Stack<Node> stack=new Stack<BinaryTree.Node>();
			while(x!=null){
				stack.push(x);
				if(x.key>key) x=x.left;
				else if(x.key<key) x=x.right;
				else { found=true; break;}
			}
			if(!found) {
				x=new Node(key,1);
				y=stack.pop();
				if(x.key>y.key) y.right=x;
				if(x.key<y.key) y.left=x;
				while(stack.size()!=0){
					y.N=size(y.left)+size(y.right)+1;
					y=stack.pop();
				}
				y.N=size(y.left)+size(y.right)+1;
			}
			
			
		}
	}
	
	public boolean get(int key) {
		boolean found=false;
		Node x=root;
		while(x!=null){
			if(x.key>key) x=x.left;
			else if(x.key<key) x=x.right;
			else { found=true; break;}
		}
		
		return found;
	}
	/*
	 * 前序递归遍历
	 */
	public void front(Node node) {
		if(node==null) return;
		
		System.out.println(node.key);
		front(node.left);
		front(node.right);
	}
	/*
	 * 前序递归复制
	 */
	public Node copyFront(Node node){
		if(node==null) return null;
		Node root=new Node(node.key, node.N);
		root.left=copyFront(node.left);
		root.right=copyFront(node.right);
		return root;
	}
	/*
	 * 前序非递归遍历，boolean仅仅是做了一个区分，没实际用处
	 */
	public void front(Node node,boolean t){
		Stack<Node> stack=new Stack<BinaryTree.Node>();
		if(node==null) return;
		while(true){
			while(node!=null){
				System.out.print(node.key);
				stack.push(node);
				node=node.left;
			}
			node=stack.pop();
			node=node.right;
			if(node==null&&stack.size()==0) break;
		}
	}
	/*
	 * 中序递归遍历，后序类似
	 */
	public void middle(Node node) {
		if(node==null) return;
		front(node.left);
		System.out.println(node.key);
		front(node.right);
	}
	
	public static void main(String[] args) {
		BinaryTree bTree=new BinaryTree();
		bTree.put(1);
		bTree.put(3);
		bTree.put(0);
		System.out.println(bTree.get(4));
		bTree.front(bTree.root,true);
		
	}
}
