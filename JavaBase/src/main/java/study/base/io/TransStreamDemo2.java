package study.base.io;
/*
1.��ȷԴ��Ŀ��
   Դ�������� InputStream Reader
   Ŀ�ģ������ OutputStream Writer
2.����������Ƿ��Ǵ��ı�
   �ǣ��ַ�����
   ���ǣ��ֽ�����
3.����ȷ��ϵ������ȷҪʹ���ĸ�����Ķ���
   ͨ���豸���
   Դ�豸���ڴ棬Ӳ�̣����̡�
   Ŀ���豸���ڴ棬Ӳ�̣�����̨��
  
 1,��һ���ı��ļ���ݴ洢����һ���ļ��С������ļ���
   Դ����Ϊ��Դ������ʹ�ö�ȡ����InputStream Reader
   �ǲ��ǲ����ı��ļ���
   �ǣ���ʱ�Ϳ���ѡ��Reader
   �������Ѿ���ȷ�ˡ�
   
   ��������ȷҪʹ�ø���ϵ���ĸ�����
   ��ȷ�豸��Ӳ�̡���һ���ļ���
   Reader��ϵ�п��Բ����ļ��Ķ����� FileReader
   �Ƿ���Ҫ���Ч�ʣ��ǣ�������Reader��ϵ�л����� BufferedReader.
   FileReader fr = new FileReader("a.txt");
   
   Ŀ�ģ�OutputStream Writer
   �Ƿ��Ǵ��ı���
   �ǣ�Writer.
   �豸��Ӳ�̣�һ���ļ���
   Writer��ϵ�п��Բ����ļ��Ķ����� FileReader
      �Ƿ���Ҫ���Ч�ʣ��ǣ�������Reader��ϵ�л����� BufferedReader.
   FileWriter fw = new FilwWriter("b.txt");
   BufferedWriter bufw = new BufferedWriter(fw);
   
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class TransStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		//System.setIn(new FileInputStream("PersonDemo.java");
		//System.setOut(new PrintStream("zzz.txt");
		//InputStream in = System.in;
		//InputStreamReader isr = new InputStreamReader(in);
		//BufferedReader bufr = new BufferedReader(isr);
		BufferedReader bufr = 
				new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw =
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}
}