package compare;

import com.alibaba.fastjson.JSONReader;
import details.Onionoo_documents_details;
import details.Relays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareImpl implements Compare {
    JSONReader reader;

    int ABW_factor;
    int len;
    int[] count;
    double[] sum;
    double[] res;
    List<Double> diff;

    public CompareImpl(JSONReader reader,int ABW_factor,int len) {
        this.reader=reader;
        this.ABW_factor=ABW_factor;
        this.len=len;
        count=new int[len];
        sum=new double[len];
        res=new double[len];
        diff=new ArrayList<>();
    }

    @Override
    public void compare() {
        reader.startArray();
        Relays relays=null;

        while (reader.hasNext()){
            relays = reader.readObject(Relays.class);

            int index=(int)Math.ceil(relays.getAdvertised_bandwidth()/Math.pow(10,ABW_factor));
//            if (!relays.getRunning()) break;
//            if (!relays.getFlags().contains("Valid")) break;
//            if (!relays.getFlags().contains("Fast")) break;

            //Guard
            if (index>=40 && index<=104){
                if (relays.getFlags().contains("Guard")){
                    if (relays.getFlags().contains("Stable") && "0.4.2".equals(relays.getVersion().substring(0,5))) {
                        count[0]++;
                        sum[0]+=relays.getGuard_probability();
                    }else {
                        count[1]++;
                        sum[1]+=relays.getGuard_probability();
                    }
                }
            }
            //Middle
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
            //Exit
            if (index>=0 && index<=5){
                if (relays.getFlags().contains("Exit")){
                    if ((!relays.getFlags().contains("Stable")) && "0.4.2".equals(relays.getVersion().substring(0,5))) {
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
            if ((i&1)==1) diff.add(res[i]-res[i-1]);
        }

        System.out.println(diff);
        reader.endArray();
    }
}
