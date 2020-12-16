package BLL;

import DTO.IDTO;
import DTO.Student;
import Repositories.RepoStudent;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author anthony
 */
public class StudentManager {
    
    private RepoStudent repoStudent;
    
    public StudentManager() throws UnknownHostException{
        repoStudent = new RepoStudent();
    }
    
    public ArrayList<IDTO> getAllStudents(){
	return repoStudent.getAll();
    }
    
    public boolean create(int id, String firstname, String lastname, String email){
        return repoStudent.create(new Student(id, firstname, lastname, email));
    }
    
}
