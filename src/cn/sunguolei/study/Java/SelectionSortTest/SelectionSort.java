package cn.sunguolei.study.SelectionSortTest;

import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Sun Guolei 2018/7/13 17:38
 */
public class SelectionSort {

    // 找出最小的
    public static int findSmallest(int[] intArray) {
        int smallest = 0;
        int smallestIndex = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < smallest) {
                smallest = intArray[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static int[] selectionSort(int[] intArray) {
        int[] resultArray = new int[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            int index = findSmallest(intArray);
            resultArray[i] = intArray[index];
        }

        return resultArray;
    }


    public static void main(String[] args) {
        int[] testArray = {23, 145, 87, 99, 2, 0, 7};
        int[] resultArray = new int[testArray.length];
        resultArray = SelectionSort.selectionSort(testArray);
        System.out.println(Arrays.toString(resultArray));

        String srcString = "ORDER_CANCELED";
        System.out.println(srcString.toLowerCase());
    }
}
