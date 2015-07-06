package com.github.ywind.sort;


/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月6日 下午2:53:17
 * 类说明
 * 
 */
public class InsertionSort {
	public static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			
			int j=i-1;
			while(a[i]<a[j]){
				j--;
				if(j==-1) break;
			}
			for(int k=i;k>j+1;k--){
				exch(a, k-1, k);
			}
		}
	}
	
	public static void exch(int[] a,int i,int j) {
		int t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	public static void main(String[] args) {
		
		int[] a={5,7,9,3,4};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
		
	}
}
