package study.base.collection;
import java.util.Arrays;
import java.util.List;
class ArraysDemo
{
	public static void main(String[] args)
	{
		//int[] arr = {2,3,5};
		//System.out.println(Arrays.toString(arr));
		String[] arr = {"abc","cc","kkkk"};
		List<String> list = Arrays.asList(arr);
		sop("contains:"+list.contains("cc"));
		Integer[] nums = {2,4,5};
		List<Integer> li = Arrays.asList(nums);
		sop(li);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}