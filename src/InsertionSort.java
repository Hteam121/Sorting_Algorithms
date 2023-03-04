public class InsertionSort {

	/**The method for sorting the numbers */
	public static String insertionSort(Integer[] list) {

		int countComp = 0, countMov = 0;

		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];

				countMov++; //Probably not right
				countComp++;
			}
			countComp++;
			
			//insert the current element into list[k + 1]
			list[k + 1] = currentElement;
			
		}


		return getCounts(countComp, countMov);
	}

	//getter method for count variables
	public static String getCounts(int countComp,int  countMov) {
		return "Comparisons: " + countComp + "\nMovements: " + countMov + "\nTotal Time: ";
	}
}