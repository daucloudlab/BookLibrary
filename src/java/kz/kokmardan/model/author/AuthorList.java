package kz.kokmardan.model.author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kz.kokmardan.db.Database;

public class AuthorList {
    
    private ArrayList<Author> authorList = new ArrayList<Author>() ;
    
    private ArrayList<Author> getAuthors(){
        Statement stmt = null ;
        Connection conn = null ;
        ResultSet rs = null ;
        try{
            conn = Database.getConnection() ;
            
            stmt = conn.createStatement() ;
            rs = stmt.executeQuery("select * from author") ;
            while (rs.next()) {
                Author author = new Author() ;
                author.setName(rs.getString("fio"));
                authorList.add(author) ;
            }
        }catch(SQLException ex){
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return authorList ;
    }
    
    public ArrayList<Author> getAuthorList(){
        if(!authorList.isEmpty()){
            return authorList ;
        }else{
            return getAuthors() ;
        }
    }
    
}
