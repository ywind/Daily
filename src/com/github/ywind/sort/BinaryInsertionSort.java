package com.github.ywind.sort;
/**
 * @author Ywind E-mail:guoshukang@vip.qq.com
 * @version 创建时间：2015年7月6日 下午8:39:20
 * 类说明
 * 
 */
public class BinaryInsertionSort {
	public static void sort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			
			int hi=i;
			int lo=0;
			int mid=0;
			while(lo<hi){
				mid=(lo+hi)/2;
				if(a[mid]>a[i])
					hi=mid-1;
				else if(a[mid]<a[i])
					lo=mid+1;
				else {lo=mid;break;};
			}

			for(int k=i;k>lo;k--){
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
		
		int[] a={5,7,9,3,4,5};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
		
	}
}