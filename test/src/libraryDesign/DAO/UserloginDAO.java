package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import libraryDesign.PO.Userlogin;

public class UserloginDAO extends DAOBase {
	
	// ��
	public void createUser(Userlogin user) throws Exception{

		// SQL���ģ��
		String CREATE_USER_SQL = "insert into user (loginID,password) values(?,?)";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_USER_SQL);
			/*
			 * ��Ҫʵ�ֵĲ��ֿ�ʼ
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */			
			pStatement.setString(1, user.getLoginID());
			pStatement.setString(2, user.getPassword());
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
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// ɾ
	// ɾ���û���½��Ϣ�������Լ������Ҫ��ɾ���û���ϸ��Ϣ��Userdetail��
	// �û���½��Ϣ���û���ϸ��ϢΪһ��һ��ϵ
	public void deleteUser(Userlogin user) throws Exception{
		// SQL���
		String DELETE_USER_SQL = "delete from user where loginID=?";
		String DELETE_USERDETAIL_SQL = "delete from userdetail where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			pStatement0 = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			pStatement0.setString(1, user.getLoginID());
			pStatement0.executeUpdate();
			pStatement0.close();			
			
			pStatement = connection.prepareStatement(DELETE_USER_SQL);
			/*
			 * ��Ҫʵ�ֵĲ��ֿ�ʼ
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, user.getLoginID());
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
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}	

	// �ع�����loginIDֱ��ɾ��
	public void deleteUser(String loginID) throws Exception{

		// SQL���
		String DELETE_USER_SQL = "delete from user where loginID=?";
		String DELETE_USERDETAIL_SQL = "delete from userdetail where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			pStatement0 = connection.prepareStatement(DELETE_USERDETAIL_SQL);
			pStatement0.setString(1, loginID);
			pStatement0.executeUpdate();
			pStatement0.close();			
						
			pStatement = connection.prepareStatement(DELETE_USER_SQL);
			/*
			 * ��Ҫʵ�ֵĲ��ֿ�ʼ
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, loginID);
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
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}		
	
	
	// ��
	// �޸�ָ����½�����û������� 
	public void updateUser(Userlogin user) throws Exception{
		// SQL���
		String UPDATE_USER_SQL = "update user set password=? where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_USER_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, user.getLoginID());
			pStatement.setString(2, user.getPassword());
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
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}		
	
	// ��
	public Userlogin queryUser(String loginID) throws Exception{
		
		//SQL���
		String QUERY_USER_SQL = "select * from user where loginID=?";
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_USER_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, loginID);
			Userlogin user = (Userlogin)pStatement.executeQuery();
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			pStatement.close();
			
			return user;
					
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