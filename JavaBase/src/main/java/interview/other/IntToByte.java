package interview.other;
/**
 * 写一段将int转换为byte[]的代码
 * int 32位 ，4个byte
 * 0x00FF 表示16进制数
 * @author ldm
 * 二进制运算
 * 1.&与操作
   2.|或操作
   3.^异或操作  相同为0
        则异或的运算法则为：0⊕0=0，1⊕0=1，0⊕1=1，1⊕1=0（同为0，异为1）
   4.~取反操作
 */
public class IntToByte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       byte[] by = tranfor(256);   // 787 = 0 0 3 19
       for(byte byt:by){
    	   //System.out.println(byt);
       }
       int x=3;
       int y=6;
       System.out.println("x=3,y=6");
       System.out.println("x&y="+(x&y));
       System.out.println(x|y);
       System.out.println(x^y);
      
       int i=3;
       System.out.println(~i);
      
       int j=-3;
       System.out.println(~j);
	}

	public static byte[] tranfor(int i){
		byte[] by = new byte[4];
		//取int最高8位，右移24位
//		by[0] = (byte) (i >> 24);
//		
//		by[1] =  (byte) ((i >> 16) & 0x00FF);
//		by[2] = (byte) (i >> 8 & 0x0000FF);
//		by[3] = (byte) (i & 0x000000FF);
		/**
		 * 直接移位转换即可，自动忽略高位
		 */
        by[0] = (byte) (i >> 24);
		
		by[1] =  (byte) (i >> 16 );
		by[2] = (byte) (i >> 8);
		by[3] = (byte) i;
		return by;
	}
}
