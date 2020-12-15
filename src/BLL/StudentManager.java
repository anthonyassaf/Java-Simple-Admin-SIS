package BLL;

import DTO.IDTO;
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
 
    
}
