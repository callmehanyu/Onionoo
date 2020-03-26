import com.alibaba.fastjson.JSONReader;
import details.Relays;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String filePath="C:\\Users\\John\\Desktop\\details\\details.json";
        int ABW_factor=6;
        int len=105;
        Compare compare = new Compare(filePath,ABW_factor,len);
        compare.compare();
    }




}
