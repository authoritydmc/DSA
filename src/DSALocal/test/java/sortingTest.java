package DSA.test.java;


import DSA.sorting.bubbleSort;
import DSA.sorting.cyclicSort;
import DSA.sorting.mergeSort;
import DSA.sorting.selectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class sortingTest {

    int [] arr = new int [] {23,2315,1,-23,551,9244,5,903,12,11,9,-45,522,-52,5302};

    int [] sortedANS = new int [] { -52, -45, -23, 1, 5, 9, 11, 12, 23, 522, 551, 903, 2315, 5302, 9244};

    int [] bsort = new bubbleSort().sort(arr.clone());

    int [] ssort = new selectionSort().sort(arr.clone());

    int [] msort = new mergeSort().sort(arr.clone());
    int [] res3=new cyclicSort().sort(new int [] { 3,1,2,7,5,6,4});

     @Test
     @DisplayName("Bubble Sort Test")
        void  bubbleSortTest()
     {

             Assertions.assertArrayEquals(sortedANS,bsort);

     }

    @Test
    @DisplayName("Merge Sort Test")
    void  mergeSortTEst()
    {

        Assertions.assertArrayEquals(sortedANS,msort);

    }

    @Test
    @DisplayName("Selection Sort Test")
    void  selectionSortTest()
    {

        Assertions.assertArrayEquals(sortedANS,ssort);

    }

    @Test
    @DisplayName("Cyclic Sort Test")
    void cyclicSortTest()
    {
        Assertions.assertArrayEquals(res3,new int [ ]{1,2,3,4,5,6,7});
    }
}
