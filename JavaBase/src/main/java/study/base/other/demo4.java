package study.base.other;

/*
 ѡ������

 */
//import java.util.*;
class demo4 {
	public static void main(String[] args) {

		int[] arr = { 2, 86, 0, 66, 5 };
		// selectSort(arr);
		// Arrays.sort(arr);
		for (int n = 0; n < 5; n++)
			System.out.print(arr[n] + " ");

	}

	public static void selectSort(int[] arr) {
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = 0; y < arr.length - x - 1; y++) {
				if (arr[y] > arr[y + 1])
					Exchange(arr, y, y + 1);

			}

		}

	}

	public static void Exchange(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = arr[a];
	}
}
