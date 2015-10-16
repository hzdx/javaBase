package study.base.other;
import static java.lang.System.out;
import static java.util.Arrays.binarySearch;
import static java.util.Arrays.sort;

import java.util.Arrays;
class StaticImport 
{
	public static void main(String[] args)
	{
		out.println("haha");
		int[] arr = {3,1,5};
		sort(arr);
		int index = binarySearch(arr,1);
		out.println(Arrays.toString(arr));
		System.out.println("Index="+index);
	}
}