package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代时移除List元素的正确方法，使用 iterator.remove();
 */
public class ConcurrentModExceptionDemo {
	public static void main(String args[]) {
		List<String> listOfPhones = new ArrayList<String>(
				Arrays.asList("iPhone 6S", "iPhone 6", "iPhone 5", "Lumia Nokia"));
		System.out.println("list of phones: " + listOfPhones);
		// This is wrong way, will throw ConcurrentModificationException
		for (String phone : listOfPhones) {
			if (phone.startsWith("iPhone")) {
				// listOfPhones.remove(phone);
			}
		}

		// The Right way, iterating elements using Iterator's remove() method
		for (Iterator<String> itr = listOfPhones.iterator(); itr.hasNext();) {
			String phone = itr.next();
			if (phone.startsWith("iPhone")) {
				// listOfPhones.remove(phone);// wrong again
				itr.remove();// right call
			}
		}
		// BigDecimal

		System.out.println("list after removal: " + listOfPhones);
	}

}