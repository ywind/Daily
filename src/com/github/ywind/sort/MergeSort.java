package com.github.ywind.sort;
/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月6日 下午4:31:56
 * 类说明
 * 
 */
public class MergeSort {
	private static int[] aux;
	
	public static void sort(int[] a,int lo,int hi) {
		if(hi<=lo) return;
		int mid=(lo+hi)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a,mid,lo,hi);
	}
	
	public static void merge(int[]a,int mid,int lo,int hi) {
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++)
			aux[k]=a[k];
		for(int k=lo;k<=hi;k++)
		{
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(aux[j]<aux[i]) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
			
	}
	
	public static void main(String[] args) {
		int[] a={5,7,9,3,4};
		aux=new int[a.length];
		sort(a,0,a.length-1);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
