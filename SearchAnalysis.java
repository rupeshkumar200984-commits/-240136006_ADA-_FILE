import java.util.*;

public class SearchAnalysis {
    // Linear Search
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int[] generateSortedArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n * 10);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 500, 1000};
        int REPEAT = 1000;

        System.out.println("----- WORST CASE (Copy to Excel) -----");
        System.out.println("n, Linear Worst, Binary Worst");
        for (int n : sizes) {
            int[] arr = generateSortedArray(n);
            int worstKey = -1;

            long start = System.nanoTime();
            for (int i = 0; i < REPEAT; i++) linearSearch(arr, worstKey);
            double linearWorst = (System.nanoTime() - start) / 1e6;

            start = System.nanoTime();
            for (int i = 0; i < REPEAT; i++) binarySearch(arr, worstKey);
            double binaryWorst = (System.nanoTime() - start) / 1e6;

            System.out.println(n + "," + linearWorst + "," + binaryWorst);
        }

        System.out.println("\n----- AVERAGE CASE (Copy to Excel) -----");
        System.out.println("n, Linear Avg, Binary Avg");
        for (int n : sizes) {
            int[] arr = generateSortedArray(n);
            int avgKey = arr[n / 2];

            long start = System.nanoTime();
            for (int i = 0; i < REPEAT; i++) linearSearch(arr, avgKey);
            double linearAvg = (System.nanoTime() - start) / 1e6;

            start = System.nanoTime();
            for (int i = 0; i < REPEAT; i++) binarySearch(arr, avgKey);
            double binaryAvg = (System.nanoTime() - start) / 1e6;

            System.out.println(n + "," + linearAvg + "," + binaryAvg);
        }

        System.out.println("\n----- BEST CASE (Copy to Excel) -----");
        System.out.println("n, Linear Best, Binary Best");
        for (int n : sizes) {
            int[] arr = generateSortedArray(n);
            int bestKey = arr[0];

            long start = System.nanoTime();
            for (int i = 0; i < REPEAT; i++) linearSearch(arr, bestKey);
            double linearBest = (System.nanoTime() - start) / 1e6;

            start = System.nanoTime();
            for (int i = 0; i < REPEAT; i++) binarySearch(arr, bestKey);
            double binaryBest = (System.nanoTime() - start) / 1e6;

            System.out.println(n + "," + linearBest + "," + binaryBest);
        }
    }
}