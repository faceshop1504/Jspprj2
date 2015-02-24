package ksh.jspprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ksh.jspprj.dao.NoticeDao;
import ksh.jspprj.model.Notice;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public Notice getNotice(String _code) {
		
		//String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
		String sql = "SELECT * FROM NOTICES WHERE CODE = '"+ _code+"'";
		

			try {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "sist", "newlec"); 
			      Statement st = con.createStatement(); 
			      ResultSet rs = st.executeQuery(sql);     
				
				rs.next();
				
				//모델 마련하기
				Notice n = new Notice();
				
				n.setCode(_code);
				n.setTitle(rs.getString("title"));
				n.setRegdate(rs.getDate("regdate"));
				n.setWriter(rs.getString("writer"));
			    n.setHit(rs.getInt("hit"));
			  	n.setContent(rs.getString("content"));
				
			  	rs.close();
				st.close();
				con.close();
				return n;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
		
	}
	@Override
	public List<Notice> getNotices(int page, String query, String field) {
		
		int start=1+(page-1)*20;
	    int end= 20+(page-1)*20;
		
		/*String sql = "SELECT *FROM (SELECT ROWNUM NUM, NO.* FROM ( "
	            + "SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) NO) "
	            + "WHERE NUM BETWEEN ? AND ?";*/
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
	    String sql = "SELECT * FROM NOTICES";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "sist", "newlec"); 
			    PreparedStatement st = con.prepareStatement(sql); 
			    st.setString(1, "%"+query+"%");
			    st.setInt(2, start);
			    st.setInt(3, end);
			    
			    ResultSet rs = st.executeQuery();     
				
			    List<Notice> list = new ArrayList<Notice>();
				
			    while(rs.next())
			    {
					//모델 마련하기
					Notice n = new Notice();
					
					n.setCode(rs.getString("code"));
					n.setTitle(rs.getString("title"));
					n.setRegdate(rs.getDate("regdate"));
					n.setWriter(rs.getString("writer"));
				    n.setHit(rs.getInt("hit"));
				  	n.setContent(rs.getString("content"));
					
				  	list.add(n);
			    }
			  	rs.close();
				st.close();
				con.close();
				
				return list;
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
		
	}
	
	@Override
	public List<Notice> getNotices(int page, String query) {
		
		return getNotices(page, query, "TITLE");
		
	}
	
	@Override
	   public int insert(Notice notice) {
	                  
	         String sqlCode = "SELECT NVL(TO_NUMBER(MAX(CODE)), 0)+1 CODE FROM NOTICES";	/*코드를생성하기위해*/
	         String sql = "INSERT INTO NOTICES(CODE, TITLE, WRITER, CONTENT, REGDATE, HIT) VALUES(?,?,?,?,SYSDATE,0)";

	         //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
	         String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
	         try {
	            //Class.forName("oracle.jdbc.driver.OracleDriver");
        	 		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            Connection con = DriverManager.getConnection(url, "sist", "newlec");
	            
	            Statement stCode=con.createStatement();
	            ResultSet rs=stCode.executeQuery(sqlCode);
	            rs.next();
	            String code=rs.getString("CODE");
	            
	            rs.close();
	            stCode.close();
	            
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, code);
	            st.setString(2, notice.getTitle());
	            st.setString(3, notice.getWriter());
	            st.setString(4, notice.getContent());

	            int result = st.executeUpdate();

	            st.close();
	            con.close();

	            return result;
	            
	         } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	         return 0;

	   }

	   @Override
	   public int update(Notice notice) {
	         String sql = "UPDATE NOTICES SET TITLE=?, CONTENT=? WHERE CODE=?";

	         //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
	         String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
	         try {
	           // Class.forName("oracle.jdbc.driver.OracleDriver");
	        	 	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            Connection con = DriverManager.getConnection(url, "sist", "newlec");
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, notice.getTitle());
	            st.setString(2, notice.getContent());
	            st.setString(3, notice.getCode());

	            int result = st.executeUpdate();

	            st.close();
	            con.close();

	            return result;
	         } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	         return 0;
	   }

	   @Override
	   public int delete(String code) {
	         String sql = "DELETE FROM NOTICES WHERE CODE=?";

	         //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
	         String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
	         try {
	            //Class.forName("oracle.jdbc.driver.OracleDriver");
	        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            Connection con = DriverManager.getConnection(url, "sist", "newlec");
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, code);

	            int result = st.executeUpdate();

	            st.close();
	            con.close();

	            return result;
	         } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } 

	         return 0;
	   }
	@Override
	public List<Notice> getNotices(int page) {
		return getNotices(page, "");
		
	}
	@Override
	public int getSize(String query, String field) {
		String sql = "SELECT COUNT(*) CNT FROM NOTICES WHERE "+field+" LIKE ? ";
		//String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";

		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(url, "sist", "newlec"); 
		    PreparedStatement st = con.prepareStatement(sql);  
		    st.setString(1, "%"+query+"%");
		    ResultSet rs = st.executeQuery();
			
		    rs.next();
		    
		    int size=rs.getInt("CNT");
				
		  	rs.close();
			st.close();
			con.close();
			return size;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	@Override
	public int getSize(String query) {
		
		return getSize(query, "TITLE");
		
	}

}