package libraryDesign.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import libraryDesign.PO.*;

public class BorrowInfoDAO extends DAOBase
{
	// ������Ϣ
	// ��
	public boolean createBorrowInfo(BorrowInfo borrowInfo) throws Exception{
		// SQL���
		String CREATE_BorrowInfo_SQL = "insert into borrowInfo(userID,bookID,borrowTime,returnTime,returnState) values(?,?,?,?,?)";

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
			pStatement.setString(1, borrowInfo.getUserID());
			pStatement.setString(2, borrowInfo.getBookID());
			pStatement.setDate(3, (java.sql.Date) borrowInfo.getBorrowTime());
			pStatement.setDate(4,(java.sql.Date) borrowInfo.getReturnTime());
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
	
	// ɾ
	// ����borrowIDɾ��������Ϣ
	public boolean deleteBorrowInfo(BorrowInfo borrowInfo) throws Exception{
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
			pStatement.setInt(1, borrowInfo.getBorrowID());
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
	public boolean updateBorrowInfo(BorrowInfo borrowInfo) throws Exception{
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
			pStatement.setDate(1, (java.sql.Date)borrowInfo.getReturnTime());
			pStatement.setString(2, borrowInfo.getReturnState());
			pStatement.setInt(3, borrowInfo.getBorrowID());
			
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
	public BorrowInfo queryBorrowInfo(Integer borrowID) throws Exception{
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
			pStatement.setInt(1, borrowID);
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			
			ArrayList borrowArray=new ArrayList<BorrowInfo>();
			ResultSet rs=pStatement.executeQuery();	
			while(rs.next()){
				BorrowInfo bi=new BorrowInfo();
				bi.setBorrowID(rs.getInt("borrowID"));
				bi.setBookID(rs.getString("bookID"));
				bi.setBorrowTime(rs.getDate("borrowTime"));
				bi.setReturnTime(rs.getDate("returnTime"));
				bi.setUserID(rs.getString("userID"));
				bi.setReturnState(rs.getString("returnState"));
				borrowArray.add(bi);
			}
			BorrowInfo borrowInfo=(BorrowInfo) borrowArray.get(0);
			pStatement.close();
			
			return borrowInfo;
					
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
