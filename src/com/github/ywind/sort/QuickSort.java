package com.github.ywind.sort;
/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月6日 下午5:09:08
 * 类说明
 * 
 */
public class QuickSort {
	public static void sort(int[] a,int lo,int hi) {
		if(hi<=lo)return;
		int v=a[lo];
		int i=lo,j=hi+1;
		while(true){
			while(a[++i]<v) if(i==hi) break;
			while(v<a[--j]) if(j==lo) break;
			if(i>=j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		sort(a, lo, j);
		sort(a, j+1, hi);
	}
	
	public static void exch(int[] a,int i,int j) {
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	public static void main(String[] args) {
		int[] a={5,7,9,3,4};
		sort(a,0,a.length-1);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
