package DTO;

/**
 *
 * @author anthony
 */
public class Student implements IDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    
    public Student(){
        
    }
    
    public Student(int id, String firstname, String lastname, String email){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
}
