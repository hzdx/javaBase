package study.base;

import java.util.Arrays;

/**
 * java实现各种排序算法
 *
 * @author ldm
 */
public class SortTest {

    public static void main(String[] args) {
        int arr[] = {4, 8, 2, 0, 12, 1, 88};
        System.out.println(Arrays.toString(arr)); // Arrays.toString 方法打印数组.
        // selectSort(arr);
        // bubbleSort(arr);
        // quickSort(arr,0,arr.length-1);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * 选择排序,o(n^2)
     */
    public static void selectSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    swap(arr, x, y);
                }
            }
        }
    }

    /**
     * 冒泡排序,o(n^2)
     */
    public static void bubbleSort(int[] arr) {
        for (int x = arr.length - 1; x > 0; x--) {
            for (int y = x - 1; y >= 0; y--) {
                if (arr[x] < arr[y]) {
                    int temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }
    }

    /**
     * 快速排序,o(nlogn)<br>
     * (通常选用数组的第一个数）作为关键数据，然后将所有比它小的数都放到它前面，<br>
     * 所有比它大的数都放到它后面，这个过程称为一趟快速排序。
     */
    public static void quickSort(int a[], int low, int high) {
        if (low >= high)
            return;
        int first = low;
        int last = high;
        int key = a[first];/* 用字表的第一个记录作为枢轴 */
        while (first < last) {
            while (first < last && a[last] >= key)
                last--;
            a[first] = a[last];/* 将比第一个小的移到低端 */
            while (first < last && a[first] <= key)
                first++;
            a[last] = a[first];/* 将比第一个大的移到高端 */
        }
        a[first] = key;/* 枢轴记录到位 */
        quickSort(a, low, first - 1);
        quickSort(a, first + 1, high);
    }

    /**
     * 堆排序,o(nlogn)<br>
     * 堆排序会将所有的数据建成一个堆，最大的数据在堆顶，<br>
     * 然后将堆顶数据和序列的最后一个数据交换。接下来再次重建堆，<br>
     * 交换数据，依次下去，就可以排序所有的数据。
     */
    public static void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);
        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            maxHeap(array, i, 0);
        }
    }

    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int half = array.length / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (index != largest) {
            swap(array, index, largest);
            maxHeap(array, heapSize, largest);
        }
    }
    // public static void heapSort(int[] data) {
    // // 构建最大堆
    // buildMaxHeap(data);
    // // 循环，每次把根节点和最后一个节点调换位置
    // for (int i = data.length; i > 1; i--) {
    // int tmp = data[0];
    // data[0] = data[i - 1];
    // data[i - 1] = tmp;
    //
    // // 堆的长度减少1，排除置换到最后位置的根节点
    // maxHeapify(data, 1, i - 1);
    // }
    // }
    //
    // // 根据输入数组构建一个最大堆
    // private static void buildMaxHeap(int[] data) {
    // for (int i = data.length / 2; i > 0; i--) {
    // maxHeapify(data, i, data.length);
    // }
    // }
    //
    // // 堆调整，使其生成最大堆
    // private static void maxHeapify(int[] data, int parentNodeIndex, int heapSize) {
    // // 左子节点索引
    // int leftChildNodeIndex = parentNodeIndex * 2;
    // // 右子节点索引
    // int rightChildNodeIndex = parentNodeIndex * 2 + 1;
    // // 最大节点索引
    // int largestNodeIndex = parentNodeIndex;
    //
    // // 如果左子节点大于父节点，则将左子节点作为最大节点
    // if (leftChildNodeIndex <= heapSize
    // && data[leftChildNodeIndex - 1] - (data[parentNodeIndex - 1]) > 0) {
    // largestNodeIndex = leftChildNodeIndex;
    // }
    //
    // // 如果右子节点比最大节点还大，那么最大节点应该是右子节点
    // if (rightChildNodeIndex <= heapSize
    // && data[rightChildNodeIndex - 1] - (data[largestNodeIndex - 1]) > 0) {
    // largestNodeIndex = rightChildNodeIndex;
    // }
    //
    // // 最后，如果最大节点和父节点不一致，则交换他们的值
    // if (largestNodeIndex != parentNodeIndex) {
    // int tmp = data[parentNodeIndex - 1];
    // data[parentNodeIndex - 1] = data[largestNodeIndex - 1];
    // data[largestNodeIndex - 1] = tmp;
    //
    // // 交换完父节点和子节点的值，对换了值的子节点检查是否符合最大堆的特性
    // maxHeapify(data, largestNodeIndex, heapSize);
    // }
    // }
}
