package kz.kokmardan.model.genre;


import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kz.kokmardan.db.Database;

public class GenreList {
    
    private ArrayList<Genre> genreList = new ArrayList<Genre>() ;
    
    private ArrayList<Genre> getGenres(){
        Statement stmt = null ;
        ResultSet rs = null; 
        Connection conn = null ;
        
        try{
            conn = Database.getConnection() ;
            stmt = conn.createStatement() ;
            rs = stmt.executeQuery("select * from genre order by name") ;
            while(rs.next()){
                Genre genre = new Genre() ;
                genre.setName(rs.getString("name"));
                genreList.add(genre );
            }
        }catch(SQLException ex){
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                if(rs != null)
                    rs.close();
                if(stmt != null)
                    stmt.close();
                if(conn != null)
                    conn.close() ;
            }catch(SQLException ex){
                Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex) ;
            }
        }
        
        return genreList ;
    }
    
    public ArrayList<Genre> getGenreList(){
        if(!genreList.isEmpty())
            return genreList ;
        else
            return getGenres() ;
    }
    
}
