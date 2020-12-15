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

import org.bson.types.ObjectId;

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
            students.add(extractStudentFromCollection(c));
        }
        
        return students;
    }
    
    public Student extractStudentFromCollection(DBObject c){
        Student student = new Student();
        student.setId((int) c.get("studentId"));
        student.setFirstname((String) c.get("firstname"));
        student.setLastname((String) c.get("lastname"));
        student.setEmail((String) c.get("email"));
        
        return student;
    }
    
    public boolean insertStudent(IDTO dto){
        Student student = (Student) dto;
        DBCollection collection = db.getCollection("student");
        /*Document document = new Document();
        document.append("id", student.getId());
        document.append("firsntame", student.getFirstname());
        document.append("lastname", student.getLastname());
        document.append("email", student.getEmail());
        //Inserting the document into the collection
        db.getCollection("students").insertOne(document);*/
        return true;
    }
    
    public boolean deleteStudent(IDTO dto){
        Student student = (Student) dto;
        return true;
    }
    
    public boolean Student(IDTO dto){
        Student student = (Student) dto;
        return true;
    }
    
    
}
