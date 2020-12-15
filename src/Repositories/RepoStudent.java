package Repositories;

import DTO.IDTO;
import DTO.Student;
import Helpers.ConnectionManager;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author anthony
 */
public class RepoStudent {
    
    DB db = null;
    
    public RepoStudent() throws UnknownHostException{
        db = ConnectionManager.getConnection();
    }
    
    public ArrayList<IDTO> getAll() {
        ArrayList<IDTO> students = new ArrayList<IDTO>();
        DBCollection collection = db.getCollection("student");
        DBCursor cursor = collection.find();

        for (DBObject c : cursor) {
            students.add(extractUserFromCollection(c));
        }
        
        return students;
    }
    
    public Student extractUserFromCollection(DBObject c){
        Student student = new Student();
        student.setId((int) c.get("studentId"));
        student.setFirstname((String) c.get("firstname"));
        student.setLastname((String) c.get("lastname"));
        student.setEmail((String) c.get("email"));
        
        return student;
    }
    
}
