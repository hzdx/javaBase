package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * 
 * 
 */
public class DateTest {

	static void create(String name, Date birthday, float money) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			conn = JdbcUtils.getConnection();
			// conn = JdbcUtilsSing.getInstance().getConnection();

			String sql = "insert into user(name,birthday, money) values (?, ?, ?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDate(2, new java.sql.Date(birthday.getTime()));
			ps.setFloat(3, money);

			int i = ps.executeUpdate();

			System.out.println("i=" + i);
		} finally {
			JdbcUtils.free(rs, ps, conn);
		}
	}

	public static void main(String[] args) throws SQLException {
		// create("name2", new Date(), 500.0f);
		Date d = read(7);
		System.out.println(d);
	}

	static Date read(int id) throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Date birthday = null;
		try {

			conn = JdbcUtils.getConnection();
			// conn = JdbcUtilsSing.getInstance().getConnection();

			st = conn.createStatement();

			rs = st.executeQuery("select birthday  from user where id=" + id);

			while (rs.next()) {
				// birthday = new Date(rs.getDate("birthday").getTime());
				birthday = rs.getDate("birthday");
			}
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
		return birthday;
	}
}
