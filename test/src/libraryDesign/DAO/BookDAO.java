package libraryDesign.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import libraryDesign.PO.*;

public class BookDAO extends DAOBase {
	
	// ��������һ���飬ÿһ���ж౾���
	public void createBook(Book book) throws Exception{
		// SQL���
		String CREATE_BOOK_SQL = "insert into book(bookID,booktypeID,clcID1,clcID2,findID,bookName,authorName,isbn,price,info,stocknum) values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(CREATE_BOOK_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, book.getBookID());
			pStatement.setString(2, book.getBooktypeID());
			pStatement.setString(3, book.getClcID1());
			pStatement.setInt(4, book.getClcID2());
			pStatement.setString(5, book.getFindID());
			pStatement.setString(6, book.getBookName());
			pStatement.setString(7, book.getAuthorName());
			pStatement.setString(8, book.getIsbn());
			pStatement.setFloat(9, book.getPrice());
			pStatement.setString(10, book.getInfo());
			pStatement.setInt(11, book.getStocknum());
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
	
	
	// ɾ��ɾ��һ����
	public void deleteBook(String bookID) throws Exception{
		// SQL���
		String DELETE_BOOK_SQL = "delete from book where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(DELETE_BOOK_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, bookID);
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
	
	// �ģ�����һ���飬�������һ
	public void addBook(String bookID) throws Exception{
		// SQL���
		String ADD_BOOK_SQL = "update book set stocknum=? where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			
			// �Ȳ�ѯ���ڷ��ؽ����ȡ�����		 
			//Integer stocknum = queryBook(bookID).getStocknum()+1;
			
			// ���¿����
			pStatement = connection.prepareStatement(ADD_BOOK_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			//pStatement.setInt(0, stocknum);
			pStatement.setString(1, bookID);
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
	
	// ɾ��ɾ��һ���飬�����Ǹ��Ŀ����������ԣ���Ŀ�����Ĳ����ϲ��ˣ�
	// �ģ����Ŀ����
	public void removeBook(String bookID) throws Exception{
		// SQL���
		String REMOVE_BOOK_SQL = "update book set stocknum=? where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			
			// �Ȳ�ѯ���ڷ��ؽ����ȡ�����		 
			//Integer stocknum = queryBook(bookID).getStocknum()-1;
			
			// ���¿����
			pStatement = connection.prepareStatement(REMOVE_BOOK_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			//pStatement.setInt(0, stocknum);
			pStatement.setString(1, bookID);
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
		
	
	// �飬��������Ų���ָ����һ���飬����һ����
	public ResultSet queryBook(String bookID) throws Exception{
		// SQL���
		String QUERY_BOOK_SQL = "select * from book where bookID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOK_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, bookID);
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			ResultSet rs=pStatement.executeQuery();	
			
			
			pStatement.close();
			
			return rs;
			
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
	
	
	// �飬�����������Ͳ��ң����ض�����
	public List<Book> queryBookByBooktypeID(String booktypeID) throws Exception{
		// SQL���
		String QUERY_BOOKBYBOOKTYPEID_SQL = "select * from book where booktypeID=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYBOOKTYPEID_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, booktypeID);
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
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
	
	
	// �飬������ͼ������1���ң����ض�����
	public List<Book> queryBookByClcID1(String clcID1) throws Exception{
		// SQL���
		String QUERY_BOOKBYCLCID1_SQL = "select * from book where clcID1=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYCLCID1_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, clcID1);
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
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
	
	
	// �飬������ͼ������2���ң����ض�����
	public List<Book> queryBookByClcID2(String clcID2) throws Exception{
		// SQL���
		String QUERY_BOOKBYCLCID2_SQL = "select * from book where clcID2=?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYCLCID2_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, clcID2);
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
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
	
	
	// �飬��������ģ����ѯ�����ض�����
	public List<Book> queryBookByBookName(String bookName) throws Exception{
		// SQL���
		String QUERY_BOOKBYBOOKNAME_SQL = "select * from book where bookName like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYBOOKNAME_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, "%"+bookName+"%");
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
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
	
	
	// �飬����������ģ����ѯ�����ض�����	
	public List<Book> queryBookByAuthorName(String authorName) throws Exception{
		// SQL���
		String QUERY_BOOKBYAUTHORNAME_SQL = "select * from book where authorName like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYAUTHORNAME_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, "%" + authorName + "%");
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
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
	
	
	// �飬�������ݼ�����ģ����ѯ�����ض�����
	public List<Book> queryBookByInfo(String info) throws Exception{
		// SQL���
		String QUERY_BOOKBYINFO_SQL = "select * from book where info like ?";

		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = getConnection();
			pStatement = connection.prepareStatement(QUERY_BOOKBYINFO_SQL);
			/*
			 * ��Ҫʵ�ֵĲ���
			 * prepare a statement to insert a record
			 * ��ղ�׼����ģ��SQL����в���������γ�������SQL����
			 */	
			pStatement.setString(1, "%" + info + "%");
			/*
			 * ��Ҫʵ�ֵĲ��ֽ���
			 */
			
			/*
			 * �̶�����
			 * ���ø��·���    executeUpdate()
			 * �ر�����    pStatement.close()
			 */
			List<Book> books = (List<Book>) pStatement.executeQuery();	
			pStatement.close();
			
			return books;
			
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