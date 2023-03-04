import java.util.*;

public class DataType {
    Integer[] array;

    public DataType(String type, int size) {
        //Given a 'datatype' and size this will construct an array of 'size' elements
        if(type.equalsIgnoreCase("In Order")) {
            this.array = inOrder(size);

        } else if(type.equalsIgnoreCase("Reverse Order")){
            this.array = reverseOrder(size);

        } else if(type.equalsIgnoreCase("Almost Order")) {
            this.array = almostOrder(size);

        } else if(type.equalsIgnoreCase("Random Order")) {
            this.array = random(size);
        }
    }

    public static Integer[] inOrder(int size){
        //creates an array from 1 to size in order
        Integer[] array = new Integer[size];

        for(int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static Integer[] reverseOrder(int size) {
        //creates an array from size to 1, reverse of inorder array
        Integer[] array = new Integer[size];

        for(int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }

    public static Integer[] almostOrder(int size) {
        Integer[] array = inOrder(size);
        Random r = new Random();

        //Swap elements size * 20% times to create an almost ordered array
        //This is so there is some level of order combined with unordered making it almost
        for(int i = 0; i < size * 0.2; i++) {

            int n1 = 0, n2 = 0;

            //Check to make sure we aren't swapping the same index within itself
            while(n1 == n2){
                n1 = r.nextInt(size);
                n2 = r.nextInt(size);
            }

            int temp = array[n1];
            array[n1] = n2;
            array[n2] = temp;
        }

        return array;
    }

    public static Integer[] random(int size) {
        Integer[] array = inOrder(size);
        Random r = new Random();

        //using the same logic as the almost order algorithm except we will be swapping around 'size' amount of times to make it more random
        for(int i = 0; i < size * 0.8; i++) {

            int n1 = 0, n2 = 0;

            //Check to make sure we aren't swapping the same index within itself
            while(n1 == n2){
                n1 = r.nextInt(size);
                n2 = r.nextInt(size);
            }

            int temp = array[n1];
            array[n1] = n2;
            array[n2] = temp;
        }
        return array;
    }
}
