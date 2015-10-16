package study.base.collection.map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
class MapIteratorDemo
{
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("01","iu");
		map.put("02","ioh");
		map.put("03","yp");
		map.put("04","ui");
		//Map.Entry<String,String>实现迭代
		Set<Map.Entry<String,String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String,String>> it = entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry<String,String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println("key:"+key+"...value:"+value);
		}
		/*
		System.out.println(map);
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while(it.hasNext())
		{
			String key = it.next();
			String value = map.get(key);
			System.out.println("key:"+key+"..value:"+value);
		}
		*/
	}
}