package study.base.collection.list;
import java.util.ArrayList;
import java.util.Iterator;
class ListDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		//���Ԫ��
		al.add("java");
		al.add("c#");
		al.add("jsp");
		sop("ԭ�����ǣ� "+al);
		//��ָ��λ�����Ԫ�ء�
		al.add(1,"xml");
		//ɾ��ָ��λ�õ�Ԫ�ء�
		al.remove(0);
		//�޸�Ԫ�ء�
		al.set(0,"sql");
		//ͨ��Ǳ��ȡԪ�ء�sql,c#,jsp.
		sop("get(1): "+al.get(1));
		//��ȡ����Ԫ�ء�
		Iterator itr = al.iterator();
		while(itr.hasNext())
		{
			sop(itr.next());
		}
	}
}