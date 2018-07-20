package cn.sunguolei.study.BinarySearchTest;

import java.util.Arrays;

/**
 * @author Sun Guolei 2018/7/12 10:28
 */
public class BinarySearch {
    public static Integer intSearch(int[] array, int value) {
        int low = 0;
        int high;
        if (array != null && array.length > 0) {
            high = array.length - 1;
            int mid = 0;
            int guess;

            while (low <= high) {
                mid = (low + high) / 2;
                guess = array[mid];
                System.out.println("guess is " + guess);
                // 如果找到了，就返回数组位置
                if (guess == value) {
                    return mid;
                } else if (guess < value) {
                    low = mid + 1;
                } else if (guess > value) {
                    high = mid - 1;
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] testArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int value = 10;

        int position = BinarySearch.intSearch(testArray, value);

        System.out.println("The position is " + position + " in the testArray " + Arrays.toString(testArray));
    }
}
