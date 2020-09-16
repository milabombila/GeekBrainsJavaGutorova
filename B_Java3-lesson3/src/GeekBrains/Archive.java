package GeekBrains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Archive {
    private String path;

    public Archive(String path) {
        this.path = path;
    }

    public synchronized void writeLog(String text) throws Exception {
        File archive = new File(path);
        FileWriter writer = new FileWriter(archive, StandardCharsets.UTF_8 , true);
        writer.append(text);
        writer.flush();
    }

    public ArrayList loadMessages(int count) throws Exception {
        File archive = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(archive, StandardCharsets.UTF_8));
        String val;
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        while ((val = reader.readLine()) != null) {
            list.add(val);
        }
//        if (list.size() < count){
//            for (int i = 0; i < list.size(); i++){
//                list2.add(list.get(i));
//            }
//        } else{
            for (int i = list.size() - count; i < list.size(); i++) {
                if(i>=0) {
                    list2.add(list.get(i));
                }
            }
//        }
        return list2;
    }
}
