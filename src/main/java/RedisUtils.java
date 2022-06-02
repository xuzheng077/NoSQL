import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Xu Zheng
 * @description
 */
public class RedisUtils {

    private static Jedis redis = null;

    private static Jedis getInstance() {
        if (redis == null) {
            redis = new Jedis("127.0.0.1", 6379);
        }
        return redis;
    }

    public static long readAllData(int dataSize) {
        Jedis redis = getInstance();
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        long start = System.currentTimeMillis();
        for (int i = 1; i <= dataSize; i++) {
            Map<String, String> map = redis.hgetAll(String.valueOf(i));
            //list.add(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("list size:  "+list.size());
        long result = end-start;
        return result;
    }

    public static long writeAllData(ArrayList<User> list) {
        System.out.println("list size:  "+list.size());
        Jedis redis = getInstance();
        long start = System.currentTimeMillis();
        for (User user : list) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("id", user.getId());
            map.put("firstname", user.getFirstName());
            map.put("lastname", user.getLastName());
            map.put("email", user.getEmail());
            map.put("gender", user.getGender());
            map.put("country", user.getCountry());
            redis.hset(user.getId(), map);
        }
        long end = System.currentTimeMillis();
        long result = end-start;
        return result;
    }

    public static long RandomQueryBasedOnKeys(int dataSize) {
        Jedis redis = getInstance();
        Random random = new Random();
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < dataSize; i++) {
            int num = random.nextInt(dataSize+1);
            Map<String, String> map = redis.hgetAll(String.valueOf(num));
            //list.add(map);
        }
        long end = System.currentTimeMillis();
        System.out.println("list size: "+list.size());
        long result = end-start;
        redis.flushAll();
        redis.flushDB();
        return result;
    }


}
