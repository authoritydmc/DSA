package DSA.sorting;

import java.util.Arrays;

public class bubbleSort {

    public int [] sort(int [] arr)
    {
        System.out.println("Bubble Sorting ");
    sortingMain.printSorted(arr);
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr.length-i-1;j++)
            {
                System.out.println("Comparing "+arr[j]+" with "+arr[j+1]);
                if (arr[j]>arr[j+1])
                {
                    System.out.println("Swapping "+arr[j+1]+" at "+arr[j]);
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    System.out.println("After swapping ");
                    sortingMain.printSorted(arr);
                }

            }
        }


        System.out.println("After sorting final ");
        sortingMain.printSorted(arr);
        return arr;

    }
}
