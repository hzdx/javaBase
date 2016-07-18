package concurrency;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import oop.User;

public class CollectionModifyExceptionTest {
	public static void main(String[] args) {
		Collection users = new CopyOnWriteArrayList();// new
														// CopyOnWriteArrayList();
		// new ArrayList();
		users.add(new User("aaa", 28));
		users.add(new User("bbb", 25));
		users.add(new User("ccc", 31));
		users.add(new User("ddd", 29));
		Iterator itrUsers = users.iterator();
		while (itrUsers.hasNext()) {
			System.out.println("aaaa");
			User user = (User) itrUsers.next();
			if ("aaa".equals(user.getName())) {
				users.remove(user);

				// itrUsers.remove();
			} else {
				System.out.println(user);
			}
		}
	}
}
