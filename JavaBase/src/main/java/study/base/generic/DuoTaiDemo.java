package study.base.generic;

/*
1����̬������
���������ָ�����Լ����������
���������Ҳ���Խ����Լ����������
2����̬��ǰ��
������������֮���й�ϵ��Ҫô�̳У�Ҫôʵ�֡�
ͨ������һ��ǰ�᣺���ڸ��ǡ�
3.�ô�����˳�����չ�ԣ���ֻ�����ø�������÷��ʸ���ĳ�Ա��
*/
class Animal
{
	public void eat(){}
}
class Cat extends Animal
{
	public void eat()
	{		
		System.out.println("eat");
	}
	public void catchMouse()
	{
		System.out.println("catch Mouse");
	}
}

class DuoTaiDemo
{
	public static void main(String[] args)
	{
		Animal a = new Cat();
		function(a);
	}
	public static void function(Animal a)
	{
		a.eat();
		if(a instanceof Cat)
		{
			Cat c = (Cat)a;//ǿ�ƽ���������ã�ת���������͡�����ת�͡�
			c.catchMouse();
		}
		
	}
}


/*
����̳и��࣬������ͬ����д��
��Ա�����ڶ�̬����ʱ�����뿴��ߣ����п��ұ�
�ڶ�̬�У���Ա�������ص㣺���۱��뻹�����У�������ߡ�(�����ͱ�����������)
��̬��Ա�������۱�������ж��ο���ߡ�

Object �����ж����ֱ�Ӻ��߼�Ӹ��ࡣ
�����ж���Ŀ϶������ж��󶼾��еĹ��ܡ�
object��equals������ʵ�ǱȽϵ�ַ��
 toString getClass().getName() + '@' + Integer.toHexString(hashCode())
 */