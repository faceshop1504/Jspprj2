package ksh.jspprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ksh.jspprj.dao.NoticeFileDao;
import ksh.jspprj.model.NoticeFile;

public class JdbcNoticeFileDao implements NoticeFileDao{

	@Override
	public List<NoticeFile> getNoticeFiles(String noticeCode) {
		
	    String sql = "SELECT * FROM NOTICEFILES WHERE CODE=?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "sist", "newlec"); 
			    PreparedStatement st = con.prepareStatement(sql); 
			    st.setString(1, noticeCode);
			    
			    
			    ResultSet rs = st.executeQuery();     
				
			    List<NoticeFile> list = new ArrayList<NoticeFile>();
				
			    while(rs.next())
			    {
					//모델 마련하기
					NoticeFile n = new NoticeFile();
					
					n.setCode(rs.getString("code"));
					n.setSrc(rs.getString("src"));
					n.setRegdate(rs.getDate("regdate"));
					n.setDescription(rs.getString("description"));
				    n.setNoticeCode(rs.getString("NoticeCode"));
				  	
					
				  	list.add(n);
			    }
			  	rs.close();
				st.close();
				con.close();
				
				return list;
				
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		return null;
	}

	@Override
	public int insert(NoticeFile file) {
		String sqlCode = "SELECT NVL(TO_NUMBER(MAX(CODE)), 0)+1 CODE FROM NOTICES";	/*코드를생성하기위해*/
        String sql = "INSERT INTO NOTICEFILES(CODE, SRC, REGDATE, DESCRIPTION, NOTICECODE) VALUES(?,?,GETDATE,?,?)";

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
           st.setString(2, file.getSrc());
           st.setString(3, file.getDescription());
           st.setString(4, file.getNoticeCode());

           int result = st.executeUpdate(); 

           st.close();
           con.close();

           return result;
           
        } catch (ClassNotFoundException e) {
           
           e.printStackTrace();
        } catch (SQLException e) {
           
           e.printStackTrace();
        }

        return 0;
	}
}
