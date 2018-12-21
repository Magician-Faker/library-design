package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import libraryDesign.PO.*;
public class DocumentDAO extends DAOBase {
	
	// ֤��Document
	// ��
	public void createDocument(Document document) throws Exception{
		// SQL���
		String CREATE_DOCUMENT_SQL = "insert into document(effdate,expdate,appdate,owed,violations,usertypeID,deposit,credits,counts) values(?,?,?,?,?,?,?,?,?) where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_DOCUMENT_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setDate(1, (java.sql.Date) document.getEffdate());
			pStatement.setDate(2, (java.sql.Date) document.getExpdate());
			pStatement.setDate(3, (java.sql.Date) document.getAppdate());
			pStatement.setFloat(4, document.getOwed());
			pStatement.setInt(5, document.getViolations());
			pStatement.setString(6, document.getUsertypeID());
			pStatement.setFloat(7, document.getDeposit());
			pStatement.setInt(8, document.getCredits());
			pStatement.setInt(9, document.getCounts());
			pStatement.setString(10, document.getDocID());
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
	// ɾ��֤������Ҫ��ɾ���û���ϸ��Ϣ������Ҫ��ɾ���û���½��Ϣ
	public void deleteDocument(Document document) throws Exception{
		// SQL���
		String DELETE_DOCUMENT_SQL = "delete from document where docID=?";
		String QUERY_USERID_SQL = "select * from userdetail where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			// ɾ���û���ϸ��Ϣ�Լ���½��Ϣ
			pStatement0 = connection.prepareStatement(QUERY_USERID_SQL);
			pStatement0.setString(1, document.getDocID());
			Userdetail userdetail = (Userdetail) pStatement0.executeQuery();
			
			UserdetailDAO ud = new UserdetailDAO();
			ud.deleteUserdetail(userdetail);
			ud.deleteUserdetail(userdetail);
			pStatement0.close();
		
			// ɾ��֤��
			pStatement = connection.prepareStatement(DELETE_DOCUMENT_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, document.getDocID());
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
	
	// ���ط���������docID����ɾ��
	public void deleteDocument(String docID) throws Exception{
		// SQL���
		String DELETE_DOCUMENT_SQL = "delete from document where docID=?";
		String QUERY_USERID_SQL = "select * from userdetail where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			// ɾ���û���ϸ��Ϣ�Լ���½��Ϣ
			pStatement0 = connection.prepareStatement(QUERY_USERID_SQL);
			pStatement0.setString(1, docID);
			Userdetail userdetail = (Userdetail) pStatement0.executeQuery();
			
			UserdetailDAO ud = new UserdetailDAO();
			ud.deleteUserdetail(userdetail);
			pStatement0.close();
		
			// ɾ��֤��
			pStatement = connection.prepareStatement(DELETE_DOCUMENT_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, docID);
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
	public void updateDocument(Document document) throws Exception{
		// SQL���
		String UPDATE_DOCUMENT_SQL = "update document set owed=?,violations=?,credits=?,counts=? where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_DOCUMENT_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setFloat(1, document.getOwed());
			pStatement.setInt(2, document.getViolations());
			pStatement.setInt(3, document.getCredits());
			pStatement.setInt(4, document.getCounts());
			pStatement.setString(5, document.getDocID());
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

	// ���ط���
	public void updateDocument(String docID,float owed,Integer violations,Integer credits,Integer counts) throws Exception{
		// SQL���
		String UPDATE_DOCUMENT_SQL = "update document set owed=?,violations=?,credits=?,counts=? where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_DOCUMENT_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setFloat(1, owed);
			pStatement.setInt(2, violations);
			pStatement.setInt(3, credits);
			pStatement.setInt(4, counts);
			pStatement.setString(5, docID);
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
	public Document queryDocument(String docID) throws Exception{
		// SQL���
		String QUERY_DOCUMENT_SQL = "select * from document where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_DOCUMENT_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, docID);
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			Document document = (Document)pStatement.executeQuery();		
			pStatement.close();
			
			return document;
					
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
