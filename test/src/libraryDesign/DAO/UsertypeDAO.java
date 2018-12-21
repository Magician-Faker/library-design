package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import libraryDesign.PO.Usertype;

public class UsertypeDAO extends DAOBase {
	
	// ��
	public boolean createUsertype(Usertype usertype) throws Exception{
		// SQL���
		String CREATE_USERTYPE_SQL = "insert into usertype(usertypeID,usertype,maxbooknum,maxorder,maxentrust) values(?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_USERTYPE_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, usertype.getUsertypeID());
			pStatement.setString(2, usertype.getUsertype());
			pStatement.setInt(3, usertype.getMaxbooknum());
			pStatement.setInt(4, usertype.getMaxorder());
			pStatement.setInt(5, usertype.getMaxentrust());
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			pStatement.executeUpdate();
			pStatement.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}	
	
	
	// ��
	public Usertype queryUsertype(String usertypeID) throws Exception{
		// SQL���
		String QUERY_USERTYPE_SQL = "select * from usertype where usertypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_USERTYPE_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, usertypeID);

			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			//Usertype usertype = (Usertype) pStatement.executeQuery();
			Usertype u=new Usertype();
			ResultSet rs=pStatement.executeQuery();
			
			while(rs.next())
			{
				u.setUsertypeID(rs.getString("usertypeID"));
				u.setUsertype(rs.getString("usertype"));
				u.setMaxorder(rs.getInt("maxorder"));
				u.setMaxbooknum(rs.getInt("maxbooknum"));
				u.setMaxentrust(rs.getInt("maxentrust"));
			}
			pStatement.close();
			
			return u;
					
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
