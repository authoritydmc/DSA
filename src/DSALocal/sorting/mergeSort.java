package DSA.sorting;

public class mergeSort {

    public void sort(int [] arr)
    {
        System.out.println("Starting merge Sort");
        mergeSortHelper(arr,0,arr.length-1);

//        sort1(arr,0,arr.length-1);
        System.out.println("Printing sorted array");
        sortingMain.printSorted(arr);
    }

    private void mergeSortHelper(int[] arr, int low, int high) {

        if(low<high)
        {
            int mid=(low+high)/2;

            mergeSortHelper(arr,low,mid);
            mergeSortHelper(arr,mid+1,high);
            merge(arr,low,mid,high);

        }

    }
    void merge1(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort1(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort1(arr, l, m);
            sort1(arr, m + 1, r);

            // Merge the sorted halves
            merge1(arr, l, m, r);
        }
    }

    private void merge(int [] arr,int low,int mid,int high)
    {
        int [] helper=new int[high-low+1];
        System.out.println("+++++++++Merging Starting at "+low+" to "+high+" with mid "+mid+"++++++++++++++");
        int size_first=mid-low+1;
        int size_second=high-mid;
        int i=0;
        int j=0;

       int cnt=0;

        while(i<size_first && j <size_second)
        {


            int first_half_adder=low+i;
            int second_half_adder=mid+1+j;
            if (arr[first_half_adder]<arr[second_half_adder])
            {
                helper[cnt++]=arr[first_half_adder];
                i++;
            }else
            {
                helper[cnt++]=arr[second_half_adder];
                j++;
            }

        }
        while (i<size_first)
        {
            int index=low+i;
            helper[cnt++]=arr[index];
            i++;
        }
        while (j<size_second)
        { int index=mid+1+j;
            helper[cnt++]=arr[index];
            j++;
        }

//        now copy sorted array to original array
        for (int ind=low;ind<=high;ind++)
        {
            arr[ind]=helper[ind-low];
        }
        System.out.println("After merge "+low+","+mid+","+high);
        sortingMain.printSorted(arr);

    }
}
