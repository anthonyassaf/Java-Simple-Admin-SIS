package Repositories;

import DTO.IDTO;
import DTO.Student;
import Helpers.ConnectionManager;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.mongodb.WriteResult;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
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

    @Override
    public IDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(IDTO dto) {
        Student student = (Student) dto;
        DBCollection collection = db.getCollection("student");
        DBObject query = QueryBuilder.start("studentId").is(student.getId()).get();
        
        DBObject update = BasicDBObjectBuilder.start()
                .add("studentId", student.getId())
                .add("firstname", student.getFirstname())
                .add("lastname", student.getLastname())
                .add("email", student.getEmail()).get();
        
       WriteResult writeResult = collection.update(query, update);
       
       return writeResult.getN() > 0;
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
    
    /*
    public boolean insertStudent(IDTO dto){
        Student student = (Student) dto;
        MongoCollection<Document> gradesCollection = db.getCollection("grades");
        Document document = new Document("_id", new ObjectId());
        document.append("id", student.getId());
        document.append("firsntame", student.getFirstname());
        document.append("lastname", student.getLastname());
        document.append("email", student.getEmail());
        //Inserting the document into the collection
        collection.insertOne(document);
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
    */
    
}
