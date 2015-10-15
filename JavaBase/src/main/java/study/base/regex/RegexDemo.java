package study.base.regex;

/*
1��ƥ�䣺string matches������  ������ʽ
splitDemo("zhangsan.lisi.wangwu","\\.");
splitDemo("c:\\abc\\a.txt","\\\\");
splitDemo("erkktyqquizzo","(.)\\1+");//���յ�������иΪ�˿����ù���Ľ�����á�
									//���Խ������װ��һ���顣��()��ɣ���ĳ��ֶ��б�š�
		
									
									//��1��ʼ����Ҫʹ�����е������ͨ�� \n(n������ı��)����ʽ��ȡ��
replaceAll(str,"\\d{5,}","#"};
replaceAll(str1,"(.)\\1+","&");
�ô����򻯶��ַ�ĸ��Ӳ�����
�׶ˣ���Ŷ���Խ�࣬����Խ�����Ķ���Խ�
*/
class RegexDemo
{
	public static void checkQQ()
	{
		String qq = "";
		int len = qq.length();
		if(len>=5 && len<=15)
		{
			if(!qq.startsWith(("0"))
			{
				char[] arr;
			}
			else
			{
				System.out.println("��������0��ͷ");
			}
		}
	}
}