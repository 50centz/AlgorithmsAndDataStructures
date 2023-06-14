
import java.util.Random;
import java.util.Arrays;
import java.util.Date;

public class HomeWork2 {

    public static void main(String[] args) {
        // int[] array = getArray();
        int[] array = { 5, 0, 5, 25, 55 };
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] getArray() {
        Random rand = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1, 100);
        }

        return array;
    }

    private static void heapSort(int[] array) {

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
        }

        heapify(array, heapSize, largest);
    }
}