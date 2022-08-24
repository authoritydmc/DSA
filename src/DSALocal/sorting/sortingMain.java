package DSA.sorting;

import java.util.Arrays;

public class sortingMain {

    public static void main(String[] args) {
        int [] arr=new int [] {23,2315,1,-23,5,903,12,11,9,-45,522};

       int [] res= new bubbleSort().sort(arr.clone());

      int [] res1= new selectionSort().sort(arr.clone());
      int [] res2= new mergeSort().sort(arr.clone());

    }

    public static void printSorted(int [] arr)
    {
        Arrays.stream(arr).forEach(x-> System.out.print(x+" , "));
        System.out.println("Done !!!");
    }
}
