import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) throws InterruptedException {

        /** TEST CODE
        DataType s = new DataType("InOrder", 1500);
        System.out.println(Arrays.toString(s.array));

        s = new DataType("ReverseOrder", 1500);
        System.out.println(Arrays.toString(s.array));

        s = new DataType("AlmostOrder", 1500);
        System.out.println(Arrays.toString(s.array));

        s = new DataType("Random", 1500);
        System.out.println(Arrays.toString(s.array));
        **/

        //Create the array of certain data type given size

        Scanner console = new Scanner(System.in);
        boolean flag = true;
        String dataType = "";

        while(flag) {
            System.out.print("1. InOrder\n2. ReverseOrder\n3. AlmostOrder\n4. Random Order\nList Properties, select the data type of list you wish to use: ");

            int choice = console.nextInt();
            console.nextLine();

            switch(choice) {
                case 1: dataType = "In Order";
                        flag = false;
                        break;

                case 2: dataType = "Reverse Order";
                        flag = false;
                        break;

                case 3: dataType = "Almost Order";
                        flag = false;
                        break;

                case 4: dataType = "Random Order";
                        flag = false;
                        break;

                default: flag = true;
                    System.out.println("Invalid Entry, please retry");
                    break;
            }
        }

        //get size
        int size = 0;
        flag = true;
        System.out.println();

        while(flag) {
            System.out.print("1. 5000\n2. 15000\n3. 50000\nInput Size, select the size of list: ");

            int choice = console.nextInt();
            console.nextLine();

            switch(choice) {
                case 1: size = 5000;
                    flag = false;
                    break;

                case 2: size = 15000;
                    flag = false;
                    break;

                case 3: size = 50000;
                    flag = false;
                    break;


                default: flag = true;
                    System.out.println("Invalid Entry, please retry");
                    break;
            }
        }

        //figure out sorting algorithm
        int sortingAlgIndex = 0;
        flag = true;
        System.out.println();

        while(flag) {
            String[] sort = {"Insertion Sort", "Selection Sort", "Quick Sort", "Merge Sort", "Heap Sort", "Radix Sort"};

            System.out.print("1. Insertion Sort\n2. Selection Sort\n3. Quick Sort\n4. Merge Sort\n5. Heap Sort\n6. Radix Sort\nSorting Algorithm, select the sorting algorithm: ");

            int choice = console.nextInt();

            if(choice > 0 && choice < 7) {
                sortingAlgIndex = choice - 1;
                flag = false;
            } else {
                System.out.println("Invalid Entry, please retry");
                flag = true;
            }
        }

        //Experimental Results
        System.out.println(experimentalResults(dataType, size, sortingAlgIndex));
    }

    public static String experimentalResults(String dataType, int size, int sortingAlgIndex){
        String[] sort = {"Insertion Sort", "Selection Sort", "Quick Sort", "Merge Sort", "Heap Sort", "Radix Sort"};
        String ans = "\nExperimental Results:\nInput Size: " + size + "\nData Type: " + dataType + "\nSort: " + sort[sortingAlgIndex] + "\n";

        int comparisons = 0, movements = 0, totalTime = 0;


        DataType d = new DataType(dataType, size);
        Integer[] array = d.array;

//        System.out.println(Arrays.toString(array));

        long start = System.nanoTime();
        switch(sortingAlgIndex) {
            case 0:
                InsertionSort sort0 = new InsertionSort();
                ans += sort0.insertionSort(array);
                break;

            case 1:
                SelectionSort sort1 = new SelectionSort();
                ans += sort1.selectionSort(array);
                break;

            case 2:
                QuickSort sort2 = new QuickSort();
                ans += sort2.quickSort(array);
                break;

            case 3:
                MergeSort sort3 = new MergeSort();
                ans += sort3.mergeSort(array);
                break;

            case 4:
                HeapSort sort4 = new HeapSort();
                ans += sort4.heapSort(array);
                break;

            case 5:
                RadixSort sort5 = new RadixSort();
                ans += sort5.radixSort(array, size);
                break;

            default:
                System.out.println("INVALID");

        }
        long time = (System.nanoTime() - start)/1000000;
        ans += time + " ms";

        return ans;
    }

}
