import com.csvreader.CsvReader;

import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author Xu Zheng
 * @description
 */
public class FileUtils {
    public static ArrayList<User> readCsv(String filePath) {
        ArrayList<User> list = new ArrayList<User>();
        try {
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));
            User user = null;
            while (reader.readRecord()) {
                String[] values = reader.getValues();
                if (values.length >= 6) {
                    user = new User(values[0], values[1], values[2], values[3], values[4], values[5]);
                }
                list.add(user);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        String filePath = "data/640000.csv";
        readCsv(filePath);
    }
}
