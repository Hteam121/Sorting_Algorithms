import java.io.*;
import java.util.*;

class RadixSort {

	private int countComp, countMov;

	public int getMax(Integer arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > mx) {
				mx = arr[i];
			}

			countComp++;
		}
		return mx;
	}

	public void countSort(Integer arr[], int n, int exp) {
		Integer output[] = new Integer[n];
		int i;
		Integer count[] = new Integer[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];

			countMov++;
		}
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;

			countMov++;
		}
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	public String radixSort(Integer arr[], int n) { // Find the maximum number to know number of digits
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);

		return getCounts(countComp, countMov);
	}

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	//getter method for count variables
	public static String getCounts(int countComp,int  countMov) {
		return "Comparisons: " + countComp + "\nMovements: " + countMov + "\nTotal Time: ";
	}

	/**
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixsort(arr, n);
		print(arr, n);
	}
	*/
}