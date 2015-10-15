package study.base.other;
class demo41
{
	public static void main(String [] args)
	{
		int [] arr={63,8,2,0};
		int index=getIndex(arr,8);
		System.out.println("index="+index);
	
	
	
	
	
	}
	public static int getIndex(int [] arr,int key)
	{
		for (int n=0;n<arr.length;n++)
		{
			if(arr[n]==key)
				return n;
		
		
		}

		return -1;
	}











}