package main.com.dorresteijn.app;

import java.io.*;
import java.lang.*;

import java.util.*;

class MergeSort_impl {

	static int toSort[];
	int n;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n");
		int n = Integer.parseInt(br.readLine());
		int toSort[] = new int[n];
		System.out.println("Enter some interger to sort");
		for (int i = 0; i < n; i++) {
			toSort[i] = Integer.parseInt(br.readLine());
		}
		MergeSort(toSort, n);

		System.out.println("sorted array");
		for (int i  :  toSort){
			System.out.println(i);
		}
	}

	public static void MergeSort(int a[], int n) {
		if (n <= 1)
			return;
		int mid = n / 2;
		int left[] = new int[mid];
		int right[] = new int[n - mid];
		for (int i = 0; i < mid; i++)
			left[i] = a[i];
		for (int i = mid; i < n; i++)
			right[i - mid] = a[i];
		MergeSort(left, mid);
		MergeSort(right, n - mid);
		Merge(left, right, a);
	}

	public static void Merge(int left[], int right[], int a[]) {
		int nL = left.length;
		int nR = right.length;
		int i, q, k;
		i = q = k = 0;
		while (i < nL && q < nR) {
			
			if (left[i] <= right[q]) {
				a[k] = left[i];
				i++;
				k++;
			} else {
				a[k] = right[q];
				q++;
				k++;
			}
		}
		while (i < nL) {
			a[k] = left[i];
			i++;
			k++;
		}
		while (q < nR) {
			a[k] = right[q];
			q++;
			k++;
		}
	}
}
