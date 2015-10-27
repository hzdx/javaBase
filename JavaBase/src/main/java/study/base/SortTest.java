package study.base;

import java.util.Arrays;

/**
 * javaʵ�ָ��������㷨
 * 
 * @author ldm
 *
 */
public class SortTest {

  public static void main(String[] args) {
    int arr[] = {4, 8, 2, 0, 12, 1, 88};
    System.out.println(Arrays.toString(arr)); // Arrays.toString ������ӡ����.
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
   * ѡ������,o(n^2)
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
   * ð������,o(n^2)
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
   * ��������,o(nlogn)<br>
   * (ͨ��ѡ������ĵ�һ��������Ϊ�ؼ����ݣ�Ȼ�����б���С�������ŵ���ǰ�棬<br>
   * ���б�����������ŵ������棬������̳�Ϊһ�˿�������
   */
  public static void quickSort(int a[], int low, int high) {
    if (low >= high)
      return;
    int first = low;
    int last = high;
    int key = a[first];/* ���ֱ�ĵ�һ����¼��Ϊ���� */
    while (first < last) {
      while (first < last && a[last] >= key)
        last--;
      a[first] = a[last];/* ���ȵ�һ��С���Ƶ��Ͷ� */
      while (first < last && a[first] <= key)
        first++;
      a[last] = a[first];/* ���ȵ�һ������Ƶ��߶� */
    }
    a[first] = key;/* �����¼��λ */
    quickSort(a, low, first - 1);
    quickSort(a, first + 1, high);
  }

  /**
   * ������,o(nlogn)<br>
   * ������Ὣ���е����ݽ���һ���ѣ����������ڶѶ���<br>
   * Ȼ�󽫶Ѷ����ݺ����е����һ�����ݽ������������ٴ��ؽ��ѣ�<br>
   * �������ݣ�������ȥ���Ϳ����������е����ݡ�
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
  // // ��������
  // buildMaxHeap(data);
  // // ѭ����ÿ�ΰѸ��ڵ�����һ���ڵ����λ��
  // for (int i = data.length; i > 1; i--) {
  // int tmp = data[0];
  // data[0] = data[i - 1];
  // data[i - 1] = tmp;
  //
  // // �ѵĳ��ȼ���1���ų��û������λ�õĸ��ڵ�
  // maxHeapify(data, 1, i - 1);
  // }
  // }
  //
  // // �����������鹹��һ������
  // private static void buildMaxHeap(int[] data) {
  // for (int i = data.length / 2; i > 0; i--) {
  // maxHeapify(data, i, data.length);
  // }
  // }
  //
  // // �ѵ�����ʹ����������
  // private static void maxHeapify(int[] data, int parentNodeIndex, int heapSize) {
  // // ���ӽڵ�����
  // int leftChildNodeIndex = parentNodeIndex * 2;
  // // ���ӽڵ�����
  // int rightChildNodeIndex = parentNodeIndex * 2 + 1;
  // // ���ڵ�����
  // int largestNodeIndex = parentNodeIndex;
  //
  // // ������ӽڵ���ڸ��ڵ㣬�����ӽڵ���Ϊ���ڵ�
  // if (leftChildNodeIndex <= heapSize
  // && data[leftChildNodeIndex - 1] - (data[parentNodeIndex - 1]) > 0) {
  // largestNodeIndex = leftChildNodeIndex;
  // }
  //
  // // ������ӽڵ�����ڵ㻹����ô���ڵ�Ӧ�������ӽڵ�
  // if (rightChildNodeIndex <= heapSize
  // && data[rightChildNodeIndex - 1] - (data[largestNodeIndex - 1]) > 0) {
  // largestNodeIndex = rightChildNodeIndex;
  // }
  //
  // // ���������ڵ�͸��ڵ㲻һ�£��򽻻����ǵ�ֵ
  // if (largestNodeIndex != parentNodeIndex) {
  // int tmp = data[parentNodeIndex - 1];
  // data[parentNodeIndex - 1] = data[largestNodeIndex - 1];
  // data[largestNodeIndex - 1] = tmp;
  //
  // // �����길�ڵ���ӽڵ��ֵ���Ի���ֵ���ӽڵ����Ƿ�������ѵ�����
  // maxHeapify(data, largestNodeIndex, heapSize);
  // }
  // }
}
