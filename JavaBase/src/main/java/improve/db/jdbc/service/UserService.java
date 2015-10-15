package improve.db.jdbc.service;

import improve.db.jdbc.dao.UserDao;


/**
 * 
 * 2008-12-6
 * 
 * @author <a href="mailto:liyongibm@gmail.com">liyong</a>
 * 
 */
public class UserService {
	private UserDao userDao;

	public void regist(jdbc.domain.User user) {
		this.userDao.addUser(user);
		// sendMail.send(user);
	}
}
