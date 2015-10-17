package improve.db.jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) throws Exception {
		template();

	}

	static void template() throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnetion(); // ��������
			st = conn.createStatement(); // �������
			rs = st.executeQuery("select * from student"); // ִ�����

			// ������
			while (rs.next()) {
				for (int i = 1; i < 5; i++) {
					System.out.print(rs.getObject(i) + "\t");
				}

				System.out.println();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtils.free(rs, st, conn);
		}
	}

	/*
	 * public static void test() throws SQLException, ClassNotFoundException {
	 * // 1.ע����
	 * 
	 * Class.forName("com.mysql.jdbc.Driver");// �Ƽ���ʽ
	 * 
	 * // 2.�������� String url = "jdbc:mysql://localhost:3306/demo"; String
	 * user = "root"; String password = "ABCD"; Connection conn =
	 * DriverManager.getConnection(url, user, password);
	 * 
	 * // 3.������� Statement st = conn.createStatement();
	 * 
	 * // 4.ִ����� ResultSet rs = st.executeQuery("select * from student");
	 * 
	 * // 5.������ while (rs.next()) { System.out.println(rs.getObject(1) + "\t"
	 * + rs.getObject(2) + "\t" + rs.getObject(3) + "\t" + rs.getObject(4)); }
	 * 
	 * // 6.�ͷ���Դ rs.close(); st.close(); conn.close(); }
	 */
}
