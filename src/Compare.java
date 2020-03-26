import com.alibaba.fastjson.JSONReader;
import details.Relays;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Compare {
    String filePath;
    int ABW_factor;
    int len;

    public Compare(String filePath, int ABW_factor, int len) {
        this.filePath = filePath;
        this.ABW_factor = ABW_factor;
        this.len = len;
    }

    public void compare(){
        int[] count=new int[len];
        double[] sum=new double[len];
        double[] res=new double[len];

        Relays relays=null;

        JSONReader reader = null;
        try {
            reader = new JSONReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        reader.startArray();
        while(reader.hasNext()) {
            relays = reader.readObject(Relays.class);
            int index=(int)Math.ceil(relays.getAdvertised_bandwidth()/Math.pow(10,ABW_factor));
//            if (!relays.getRunning()) break;
//            if (!relays.getFlags().contains("Valid")) break;
//            if (!relays.getFlags().contains("Fast")) break;
            if (index>=20 && index<=40){
                if (relays.getFlags().contains("Guard")){
                    if (relays.getFlags().contains("Stable") && "0.4.3".equals(relays.getVersion().substring(0,5))) {
                        count[0]++;
                        sum[0]+=relays.getGuard_probability();
                    }else {
                        count[1]++;
                        sum[1]+=relays.getGuard_probability();
                    }
                }
            }
            if (index>=20 && index<=40){
                if ((!relays.getFlags().contains("Guard")) && (!relays.getFlags().contains("Exit")) ){
                    if ((!relays.getFlags().contains("Stable")) && "0.4.2".equals(relays.getVersion().substring(0,5))) {
                        count[2]++;
                        sum[2]+=relays.getMiddle_probability();
                    }else {
                        count[3]++;
                        sum[3]+=relays.getMiddle_probability();
                    }
                }
            }
            if (index>=20 && index<=40){
                if (relays.getFlags().contains("Exit")){
                    if ((relays.getFlags().contains("Stable")) && "0.4.2".equals(relays.getVersion().substring(0,5))) {
                        count[4]++;
                        sum[4]+=relays.getExit_probability();
                    }else {
                        count[5]++;
                        sum[5]+=relays.getExit_probability();
                    }
                }
            }

        }
        for (int i = 0; i < len; i++) {
            res[i]=sum[i]/count[i];
        }
        System.out.println(Arrays.toString(res));
        reader.endArray();
        reader.close();
    }
}
