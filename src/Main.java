import com.alibaba.fastjson.JSONReader;
import compare.CompareImpl;
import details.Onionoo_documents_details;
import details.Relays;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String filesPath="C:\\Users\\John\\Desktop\\details";

//        Compare compare = new Compare(filePath,ABW_factor,len);
//        compare.compare();

        File file = new File(filesPath);
        String[] list = file.list();
        for (String s:list){
            if (s.length()!=18) continue;
            JSONReader reader = null;
            String filePath=filesPath+"\\"+s;

            try {
                reader = new JSONReader(new FileReader(filePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            reader.startObject();
            while (reader.hasNext()){
                String key = reader.readString();

                if ("relays".equals(key)){

                    CompareImpl compare = new CompareImpl(reader, 6, 6);

                    try {
                        compare.compare();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        continue;
                    }
                }
                reader.readString();
            }
            reader.endObject();
            reader.close();
        }
    }




}
