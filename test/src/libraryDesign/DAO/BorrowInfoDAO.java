package library.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import library.PO.BorrowInfo;
import library.PO.Document;
import library.PO.Userdetail;

public class BorrowInfoDAO extends DAOBase
{
	// ������Ϣ
	// ��
	public void createBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		// SQL���
		String CREATE_BorrowInfo_SQL = "insert into borrowInfo(userID,bookID,borrowTime,returnTime,borrowID,returnState) values(?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BorrowInfo_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, borrowInfo.getUserID());
			pStatement.setString(1, borrowInfo.getBookID());
			pStatement.setDate(2, (java.sql.Date) borrowInfo.getBorrowTime());
			pStatement.setDate(3,(java.sql.Date) borrowInfo.getReturnTime());
			pStatement.setString(4, borrowInfo.getBorrowID());
			pStatement.setString(5, borrowInfo.getReturnState());
			
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
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}	
	
	// ɾ
	// ����borrowIDɾ��������Ϣ
	public void deleteBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		// SQL���
		String DELETE_BorrowInfo_SQL = "delete from borrowInfo where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
		
			// ɾ��֤��
			pStatement = connection.prepareStatement(DELETE_BorrowInfo_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, borrowInfo.getBorrowID());
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
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}
		
	// ��
	public void updateBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		// SQL���
		String UPDATE_BorrowInfo_SQL = "update borrowInfo set returnTime=?,returnState=? where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(UPDATE_BorrowInfo_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setDate(0, (java.sql.Date)borrowInfo.getReturnTime());
			pStatement.setString(1, borrowInfo.getReturnState());
			pStatement.setString(2, borrowInfo.getBookID());
			
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
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}	

	// ��
	public BorrowInfo queryBorrowInfo(String borrowID) throws Exception{
		// SQL���
		String QUERY_BorrowInfo_SQL = "select * from borrowInfo where borrowID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BorrowInfo_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(0, borrowID);
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			BorrowInfo borrowInfo = (BorrowInfo)pStatement.executeQuery();		
			pStatement.close();
			
			return borrowInfo;
					
		}catch(Exception e) {
			throw new DAOException();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				throw new DAOException();
			}
		}
	}		
}
