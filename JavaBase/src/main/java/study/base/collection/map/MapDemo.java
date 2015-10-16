package study.base.collection.map;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
class MapDemo
{
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("put:"+map.put("01","zhangsan"));
		System.out.println("put:"+map.put("01","zshn"));//�����ı����ǣ��������ء�
		map.put("02","iu");
		map.put("03","zssf");
		map.put("04","zshsfs");
		System.out.println(map);
		Collection<String> coll = map.values();
		System.out.println(coll);
		sop(map.remove("01"));
		sop(map.get("05"));
		map.put("05",null);
		sop(map.get("05"));
		map.put(null,"sfs");
		sop(map.get(null));
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}