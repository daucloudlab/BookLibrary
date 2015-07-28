package kz.kokmardan.model.genre;

public class Genre {
    
    private String name ;
    private long id;    
    
    public Genre(){}
    
    public Genre(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public void setName(String name){
        this.name = name ;
    }
    
    public String getName(){
        return this.name ;
    }
    
}
