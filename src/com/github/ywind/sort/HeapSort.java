package com.github.ywind.sort;
/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月6日 下午3:04:00
 * 
 * 堆排序可以利用下沉或者上浮，类中都有写
 */
public class HeapSort {
	
	public static void sort(int[] a) {
		int N=a.length-1;
//		for(int k=N/2;k>=0;k--)
//			sink(a, k, N);
//		
		for(int k=N;k>=N/2;k--)
			swim(a, k, N);
		
		while(N>0){
			exch(a, N--, 0);
			sink(a, 0, N);
		}
	}
	private static void exch(int[] a,int i,int j) {
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	private static void sink(int[] a,int k,int N){
		while(2*k<=N){
			int j=2*k;
			while(j<N&&a[j]<a[j+1]) j++;
			if(a[k]>=a[j]) break;
			exch(a, k, j);
			k=j;
		}
	}
	private static void swim(int[] a,int k,int N) {
		while(k>0&&a[k/2]<a[k])
		{
			exch(a, k/2, k);
			k=k/2;
		}
	}
	
	public static void main(String[] args) {
		
		int[] a={5,7,9,3,4};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
		
	}
}
