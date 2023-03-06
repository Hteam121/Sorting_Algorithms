
public class SelectionSort {
	/** The method for sorting the numbers */
	public static String selectionSort(Integer[] list) { //int[] list?

		int countComp = 0, countMov = 0;

		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i+1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;

				}
				countComp++;
			}
			
			//	Swap list[i] with list[currentMinIndex[ if necessary
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;

				countMov++;
			}
			countComp++;
		}

		return getCounts(countComp, countMov);
	}

	//getter method for count variables
	public static String getCounts(int countComp,int  countMov) {
		return "Comparisons: " + countComp + "\nMovements: " + countMov + "\nTotal Time: ";
	}
}
