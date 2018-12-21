package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import libraryDesign.PO.Userlogin;

public class UserloginDAO extends DAOBase {
	
	// ��
	public void createUserlogin(Userlogin user) throws Exception{

		// SQL���ģ��
		String CREATE_USER_SQL = "insert into userlogin (loginID,password) values(?,?)";
		
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
	public boolean deleteUser(Userlogin user) throws Exception{
		// SQL���
		String DELETE_USER_SQL = "delete from userlogin where loginID=?";
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
			pStatement.setString(1, user.getLoginID());
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

	// �ع�����loginIDֱ��ɾ��
	public boolean deleteUser(String loginID) throws Exception{

		// SQL���
		String DELETE_USER_SQL = "delete from userlogin where loginID=?";
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
			pStatement.setString(1, loginID);
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
	// �޸�ָ����½�����û������� 
	public void updateUserlogin(Userlogin user) throws Exception{
		// SQL���
		String UPDATE_USER_SQL = "update userlogin set password=? where loginID=?";
		
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
			pStatement.setString(2, user.getLoginID());
			pStatement.setString(1, user.getPassword());
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
	public Userlogin queryUserlogin(String loginID) throws Exception{
		
		//SQL���
		String QUERY_USER_SQL = "select * from userlogin where loginID=?";
		
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
			Userlogin ul=new Userlogin();
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()){
				
				ul.setLoginID(rs.getString(1));
				ul.setPassword(rs.getString(2));
			}
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			pStatement.close();
			
			return ul;
					
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
