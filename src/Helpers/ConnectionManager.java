package Helpers;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 *
 * @author anthony
 */
public class ConnectionManager {
    
     public static DB getConnection() throws UnknownHostException {
        // Creating a Mongo client
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("JavaAdminSIS");
        System.out.println("Connected!");
        return db;
    }

    public static void closeConnection(MongoClient client) {
        client.close();
        System.out.println("DisConnected!");
    }
    
}
