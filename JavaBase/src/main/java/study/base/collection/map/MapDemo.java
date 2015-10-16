package study.base.collection.map;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
class MapDemo
{
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("put:"+map.put("01","zhangsan"));//put:null
		System.out.println("put:"+map.put("01","zshn"));//put:zhangsan
		map.put("02","iu");
		map.put("03","zssf");
		map.put("04","zshsfs");
		System.out.println(map);//{01=zshn, 02=iu, 03=zssf, 04=zshsfs}
		Collection<String> coll = map.values();
		System.out.println(coll);//[zshn, iu, zssf, zshsfs]
		sop(map.remove("01"));//zshn
		sop(map.get("05"));//null
		map.put("05",null);
		//hashMap可以使用null为key,value
		sop(map.get("05"));//null
		map.put(null,"sfs");
		sop(map.get(null));//sfs
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}