package DSA.sorting;

public class selectionSort {
    public int []  sort(int [] arr)
    {
        System.out.println("Selection Sort Starting");
        System.out.println("Before sorting ");
        sortingMain.printSorted(arr);
    for (int i=0;i<arr.length;i++)
    {
        int min=i;
        for (int j=i;j<arr.length;j++)
        {
            if (arr[j]<arr[min])
                min=j;

        }
        int temp=arr[i];
        arr[i]=arr[min];
        arr[min]=temp;
    }


        System.out.println("After sorting final ");
        sortingMain.printSorted(arr);
        return arr;
    }
}
