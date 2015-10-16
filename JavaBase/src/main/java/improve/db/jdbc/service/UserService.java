package improve.db.jdbc.service;

import improve.db.jdbc.dao.UserDao;
import improve.db.jdbc.domain.User;


/**
 * 
 * 
 */
public class UserService {
	private UserDao userDao;

	public void regist(User user) {
		this.userDao.addUser(user);
		// sendMail.send(user);
	}
}
