import com.mongodb.*;
import com.mongodb.util.JSON;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Xu Zheng
 * @description
 */
public class MongoDBUtils {

    private static MongoClient mongo = null;

    public static MongoClient getInstance() {
        if (mongo == null) {
            mongo = new MongoClient("127.0.0.1", 27017);
        }
        return mongo;
    }

    public static long readAllData(int dataSize) {
        ArrayList<DBObject> list = new ArrayList<DBObject>();
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("user");
        long start = System.currentTimeMillis();
        for (int i=1;i<=dataSize;i++){
            BasicDBObject queryObject = new BasicDBObject("_id",String.valueOf(i));
            DBObject object = users.findOne(queryObject);
        }
        long end = System.currentTimeMillis();
        System.out.println(list.size());
        return end - start;
    }

    public static long writeAllData(ArrayList<User> list) {
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("user");
        long start = System.currentTimeMillis();
        for (User user : list) {
            DBObject user_json = (DBObject) JSON.parse(user.toJSON());
            users.insert(user_json);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long queryBasedOnKeys(int dataSize) {
        Random random = new Random();
        ArrayList<DBObject> list = new ArrayList<DBObject>();
        DB db = mongo.getDB("test");
        DBCollection users = db.getCollection("user");
        long start = System.currentTimeMillis();
        for (int i=0;i<dataSize;i++){
            int num = random.nextInt(dataSize+1);
            BasicDBObject queryObject = new BasicDBObject("_id",String.valueOf(num));
            DBObject object = users.findOne(queryObject);
            list.add(object);
        }
        long end = System.currentTimeMillis();
        System.out.println(list.size());
        db.dropDatabase();
        return end - start;
    }
}
