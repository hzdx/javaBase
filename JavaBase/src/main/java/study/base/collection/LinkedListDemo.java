package study.base.collection;
import java.util.LinkedList;
class LinkedListDemo
{
	public static void main(String[] args)
	{
		LinkedList link = new LinkedList();
		link.addLast("java01");
		link.addLast("java02");
		link.addLast("java03");
		link.addFirst("java04");
		sop("ԭlink:"+link);
		sop("ȡlink��һ��Ԫ�أ�"+link.getFirst());
		sop("ȡlink���һ����Ԫ�أ�"+link.getLast());
		sop("ɾ��link��һ��Ԫ�أ�"+link.removeFirst());
		sop("ɾ��link��һ��Ԫ�أ�"+link.removeFirst());
		sop("�޸ĺ�link��Ԫ�ظ���"+link.size());
		while(!link.isEmpty())
		{
			sop(link.removeLast());
		}
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
