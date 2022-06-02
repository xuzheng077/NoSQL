import redis.clients.jedis.Jedis;

import java.util.ArrayList;

/**
 * @author Xu Zheng
 * @description
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<User> list_500 = FileUtils.readCsv("data/500.csv");
        ArrayList<User> list_1000 = FileUtils.readCsv("data/1000.csv");
        ArrayList<User> list_10000 = FileUtils.readCsv("data/10000.csv");
        ArrayList<User> list_20000 = FileUtils.readCsv("data/20000.csv");
        ArrayList<User> list_40000 = FileUtils.readCsv("data/40000.csv");
        ArrayList<User> list_80000 = FileUtils.readCsv("data/80000.csv");
        ArrayList<User> list_160000 = FileUtils.readCsv("data/160000.csv");
        ArrayList<User> list_320000 = FileUtils.readCsv("data/320000.csv");
        ArrayList<User> list_640000 = FileUtils.readCsv("data/640000.csv");

        //write
        long write_time = MongoDBUtils.writeAllData(list_500);

        //read
        long read_time = MongoDBUtils.readAllData(500);

        //random
        long random_time = MongoDBUtils.queryBasedOnKeys(500);

        System.out.println("write: "+write_time);
        System.out.println("read:  "+read_time);
        System.out.println("random:  "+random_time);
    }

}
