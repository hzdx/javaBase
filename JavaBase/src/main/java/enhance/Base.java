package enhance;

/**
 * 初始化过程：父类静态->子类静态->父类初始化常量，代码块->父类构造方法
 * ->子类初始化常量，代码块->子类构造方法
 * 因为这里父类在构造函数中调用了子类的方法，而子类的常量还没有被初始化
 * 所有输出为 null
 */
public class Base
{
    private String baseName = "base";
    public Base()
    {
        callName();
    }
 
    public void callName()
    {
        System. out. println(baseName);
    }
 
    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}