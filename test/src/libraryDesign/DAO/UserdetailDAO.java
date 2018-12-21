package libraryDesign.DAO;

import java.sql.*;

import libraryDesign.PO.Userdetail;

public class UserdetailDAO extends DAOBase {
	
	// ��
	public void createUserdetail(Userdetail userdetail) throws Exception{
		// SQL���
		String CREATE_USERDETAIL_SQL = "insert into userdetail(userID,userName,docID,college,profession,sex,mail,loginID) values(?,?,?,?,?,?,?,?)";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_USERDETAIL_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, userdetail.getUserID());
			pStatement.setString(2, userdetail.getUserName());
			pStatement.setString(3, userdetail.getDocID());
			pStatement.setString(4, userdetail.getCollege());
			pStatement.setString(5, userdetail.getProfession());
			pStatement.setString(6, userdetail.getSex());
			pStatement.setString(7, userdetail.getMail());
			pStatement.setString(8, userdetail.getLoginID());
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
					
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.close();
			}catch(SQLException ee) {
				ee.printStackTrace();
			}
		}
	}
	
	// ɾ
	// ɾ���û���ϸ��Ϣ��Ӧ�ٱ����û���½��Ϣ��һ��ɾ��
	// ��ɾ����ϸ��Ϣ����ɾ����½��Ϣ
	public void deleteUserdetail(Userdetail userdetail) throws Exception{

		// SQL���
		String DELETE_USERDETAIL_SQL = "delete from userdetail where userID=?";
		String DELETE_USER_SQL = "delete from user where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, userdetail.getUserID());
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
			
			// ɾ����½��Ϣ
			pStatement0 = connection.prepareStatement(DELETE_USER_SQL);
			pStatement0.setString(1, userdetail.getLoginID());
			pStatement0.executeUpdate();
			pStatement0.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// ���أ������û���ɾ���û���ϸ��Ϣ
	public void deleteUserdetail(String userID) throws Exception{
		
		// SQL���
		String DELETE_USERDETAIL_SQL = "delete from userdetail where userID=?";
		String DELETE_USER_SQL = "delete from user where loginID=?";
				
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, userID);
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
			
			// ɾ����½��Ϣ
			Userdetail userdetail = queryUserdetail(userID);
			pStatement0 = connection.prepareStatement(DELETE_USER_SQL);
			pStatement0.setString(1, userdetail.getLoginID());
			pStatement0.executeUpdate();			
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// ��
	public Userdetail updateUserdetail(Userdetail userdetail) throws Exception{

		// SQL
		String UPDATE_USERDETAIL_SQL = "update userdetail set userName=?,docID=?,college=?,profession=?,sex=?,mail=?,loginID=? where userID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USERDETAIL_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, userdetail.getUserName());
			pStatement.setString(2, userdetail.getDocID());
			pStatement.setString(3, userdetail.getCollege());
			pStatement.setString(4, userdetail.getProfession());
			pStatement.setString(5, userdetail.getSex());
			pStatement.setString(6, userdetail.getMail());
			pStatement.setString(7, userdetail.getLoginID());			
			pStatement.setString(8, userdetail.getUserID());
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
			
			return userdetail;
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return userdetail;
	}		
	
	// ��
	// �����û������в�ѯ�����ز�ѯ����Userdetail
	public Userdetail queryUserdetail(String userID) throws Exception{

		// SQL
		String QUERY_USERDETAIL_SQL = "select * from userdetail where userID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_USERDETAIL_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, userID);
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			Userdetail userdetail = (Userdetail)pStatement.executeQuery();

			pStatement.close();
			
			return userdetail;
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}	
	

}