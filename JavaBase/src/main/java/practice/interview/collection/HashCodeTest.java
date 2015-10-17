package practice.interview.collection;

/**
 * hashCode的作用： 当一个类采用哈希算法进行存储和检索时，会要求覆盖hashCode方法。
 * 一个实例会计算出哈希值，java会按照这个哈希值查找实例在内存中存储的区域 简单来说，hashCode值就相当于对象的索引，程序按这个索引查找
 * 如果对象存入集合后，改变了hash值，则会导致内存泄漏 equals方法结果为true，则哈希值一定相等，反之则不一定成立。
 * 
 * @author ldm
 *
 */
public class HashCodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
