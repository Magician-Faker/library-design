package libraryDesign.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import libraryDesign.PO.*;
public class DocumentDAO extends DAOBase {
	
	// 证件Document
	// 增
	public void createDocument(Document document) throws Exception{
		// SQL语句
		String CREATE_DOCUMENT_SQL = "insert into document(effdate,expdate,appdate,owed,violations,usertypeID,deposit,credits,counts) values(?,?,?,?,?,?,?,?,?) where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_DOCUMENT_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
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
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
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
	
	// 删
	// 删除证件，需要先删除用户详细信息，又需要先删除用户登陆信息
	public void deleteDocument(Document document) throws Exception{
		// SQL语句
		String DELETE_DOCUMENT_SQL = "delete from document where docID=?";
		String QUERY_USERID_SQL = "select * from userdetail where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			// 删除用户详细信息以及登陆信息
			pStatement0 = connection.prepareStatement(QUERY_USERID_SQL);
			pStatement0.setString(1, document.getDocID());
			Userdetail userdetail = (Userdetail) pStatement0.executeQuery();
			
			UserdetailDAO ud = new UserdetailDAO();
			ud.deleteUserdetail(userdetail);
			ud.deleteUserdetail(userdetail);
			pStatement0.close();
		
			// 删除证件
			pStatement = connection.prepareStatement(DELETE_DOCUMENT_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(0, document.getDocID());
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
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
	
	// 重载方法，根据docID进行删除
	public void deleteDocument(String docID) throws Exception{
		// SQL语句
		String DELETE_DOCUMENT_SQL = "delete from document where docID=?";
		String QUERY_USERID_SQL = "select * from userdetail where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		PreparedStatement pStatement0 = null;
		try {
			connection = getConnection();
			
			// 删除用户详细信息以及登陆信息
			pStatement0 = connection.prepareStatement(QUERY_USERID_SQL);
			pStatement0.setString(1, docID);
			Userdetail userdetail = (Userdetail) pStatement0.executeQuery();
			
			UserdetailDAO ud = new UserdetailDAO();
			ud.deleteUserdetail(userdetail);
			pStatement0.close();
		
			// 删除证件
			pStatement = connection.prepareStatement(DELETE_DOCUMENT_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, docID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
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
	
	
		
	// 改
	public void updateDocument(Document document) throws Exception{
		// SQL语句
		String UPDATE_DOCUMENT_SQL = "update document set owed=?,violations=?,credits=?,counts=? where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_DOCUMENT_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setFloat(1, document.getOwed());
			pStatement.setInt(2, document.getViolations());
			pStatement.setInt(3, document.getCredits());
			pStatement.setInt(4, document.getCounts());
			pStatement.setString(5, document.getDocID());
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
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

	// 重载方法
	public void updateDocument(String docID,float owed,Integer violations,Integer credits,Integer counts) throws Exception{
		// SQL语句
		String UPDATE_DOCUMENT_SQL = "update document set owed=?,violations=?,credits=?,counts=? where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_DOCUMENT_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setFloat(1, owed);
			pStatement.setInt(2, violations);
			pStatement.setInt(3, credits);
			pStatement.setInt(4, counts);
			pStatement.setString(5, docID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
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
	
	// 查
	public Document queryDocument(String docID) throws Exception{
		// SQL语句
		String QUERY_DOCUMENT_SQL = "select * from document where docID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_DOCUMENT_SQL);
			/*
			 * 需要实现的部分
			 * prepare a statement to insert a record
			 * 向刚才准备的模板SQL语句中插入参数，形成完整的SQL命令
			 */	
			pStatement.setString(1, docID);
			/*
			 * 需要实现的部分结束
			 */
			
			/*
			 * 固定动作
			 * 调用更新方法    executeUpdate()
			 * 关闭连接    pStatement.close()
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
