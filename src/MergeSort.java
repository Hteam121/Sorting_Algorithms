
public class MergeSort {
	/**	The method for sorting the numbers */

	private int countComp, countMov;

	public String mergeSort(Integer[] list) {
		if (list.length > 1) {
			//	Merge sort the first half
			Integer [] firstHalf = new Integer[list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf);
			
			//Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			Integer[] secondHalf = new Integer[secondHalfLength];
			System.arraycopy(list, list.length / 2, 
				secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			//	Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}

		return getCounts();
	}
	
	/** Merge two sorted list */
	public void merge(Integer[] list1, Integer[] list2, Integer[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp
		
		while (current1 < list1.length && current2 < list2.length) {
			countMov++;

			if (list1[current1] < list2[current2])
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		
		while (current1 < list1.length) {
			temp[current3++] = list1[current1++];

			countMov++;
		}

		
		while (current2 < list2.length) {
			temp[current3++] = list2[current2++];

			countMov++;
		}

		countComp += 4;
	}

	public  String getCounts() {
		return "Comparisons: " + countComp + "\nMovements: " + countMov + "\nTotal Time: ";
	}

	/**
	/** A test method *
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		mergeSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.println(list[i] + " ");
	}
	*/
}
