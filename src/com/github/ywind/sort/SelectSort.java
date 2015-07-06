package com.github.ywind.sort;
/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月6日 下午5:22:32
 * 类说明
 * 
 */
public class SelectSort {
	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int v=i;
			for (int j = i; j < a.length; j++) {
				if(a[j]<a[v]) v=j;
			}
			exch(a, i, v);
		}
	}
	
	public static void exch(int[] a,int i,int j) {
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	public static void main(String[] args) {
		
		int[] a={5,7,9,3,4,5};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
		
	}
}
