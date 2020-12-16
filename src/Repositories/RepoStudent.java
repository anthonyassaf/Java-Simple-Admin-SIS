package Repositories;

import DTO.IDTO;
import DTO.Student;
import Helpers.ConnectionManager;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author anthony
 */
public class RepoStudent implements IRepo{
    
    DB db = null;
    
    public RepoStudent() throws UnknownHostException{
        db = ConnectionManager.getConnection();
    }
    
    @Override
    public ArrayList<IDTO> getAll() {
        ArrayList<IDTO> students = new ArrayList<>();
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

    @Override
    public IDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(IDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(IDTO dto) {
        Student student = (Student) dto;
        DBCollection collection = db.getCollection("student");
        
        DBObject document = new BasicDBObject();
        document.put("studentId", student.getId());
        document.put("firstname", student.getFirstname());
        document.put("lastname", student.getLastname());
        document.put("email", student.getEmail());
        
        WriteResult writeResult = collection.insert(document);
        
        return writeResult.getN() == 0;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
