package org.itstep;

public class App {

    static int[] arr;

    public static int[] quickSort(int[] input) {
        arr = input;
        quickSort(0, input.length - 1);
        return arr;
    }

    private static void quickSort(int low, int high) {
        if (arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int idx = low + (high - low) / 2;
        int pivot = arr[idx]; // опорный элемент

        int i=low, j = high;
        while(i <= j) {
            while(arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if(i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        if(low <= i) {
            quickSort(low, j);
        }
        if(j <= high) {
            quickSort(i, high);
        }
    }
}
