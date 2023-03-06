public class QuickSort {

	/**
	Need to keep track of variables: countMov and countComp
	 So I setup global variables
	 **/

	private int countComp, countMov;

	public  String quickSort(Integer[] list) {
		quickSort(list, 0, list.length-1);

		return getCounts();
	}
	
	public  void quickSort(Integer[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex -1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public  int partition(Integer[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
			// Search forward from left
			while (low <= high && list[low] <= pivot){
				low++;

				countComp++;
			}

			// Search backward from right
			while (low <= high && list[high] > pivot) {
				high--;

				countComp++;
			}

			//	Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;

				countMov++;
			}
			countComp++;
		}
		
		while (high > first && list[high] >= pivot){
			high--;

			countComp++;
		}

		countComp += 2;
		//	Swap pivot with list[high]
		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;

			countMov++;
			return high;
		}
		else {
			return first;
		}
	}

	//getter method for count variables
	public  String getCounts() {
		return "Comparisons: " + countComp + "\nMovements: " + countMov + "\nTotal Time: ";
	}
}
