import com.alibaba.fastjson.JSONReader;
import details.Relays;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Measure {
    String filePath="C:\\Users\\John\\Desktop\\details.json";

    public Measure(String filePath) {
        this.filePath = filePath;
    }
    //JSON_read_all(filePath,6,105,"Exit");
    //JSON_read_stable(filePath,6,105,"Exit");
    //JSON_read_cc(filePath,6,105,"Exit");
    //JSON_read_as(filePath,6,105,"Middle");
    //JSON_read_version(filePath,6,105,"Middle");
    //JSON_read_fast(filePath);
    private static double getProbability(Relays relays, String position) {
        double probability = 0.0;
        switch (position) {
            case "Guard":
                probability = relays.getGuard_probability();
                break;
            case "Middle":
                probability = relays.getMiddle_probability();
                break;
            case "Exit":
                probability = relays.getExit_probability();
                break;
        }
        return probability;
    }
    private static void statistics(int abw,double probability,int ABW_factor,double[] sum_arr,int[] count_arr){
        if (abw==0){
            sum_arr[0]+=probability;
            count_arr[0]++;
        }else{
            int index=(int)Math.ceil(abw/Math.pow(10,ABW_factor));
            sum_arr[index]+=probability;
            count_arr[index]++;
        }
    }

    private static void JSON_read_all(String filePath,int ABW_factor,int len,String position) {
        double sum_arr[]=new double[len];
        int count_arr[]=new int[len];
        double avg_arr[]=new double[len];
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
            if (relays.getRunning()){
                int abw=relays.getAdvertised_bandwidth();
                double probability = getProbability(relays, position);
                statistics(abw,probability,ABW_factor,sum_arr,count_arr);
            }
        }
        for (int i = 0; i < len; i++) {
            if (count_arr[i]!=0) avg_arr[i]=sum_arr[i]/count_arr[i];
        }
        for (int i = 0; i < len; i++) {
            System.out.println(i+"\t"+avg_arr[i]);
        }
        reader.endArray();
        reader.close();
    }

    private static void JSON_read_stable(String filePath,int ABW_factor,int len,String position) {
        double sum_stable_arr[]=new double[len];
        int count_stable_arr[]=new int[len];
        double avg_stable_arr[]=new double[len];

        double sum_unstable_arr[]=new double[len];
        int count_unstable_arr[]=new int[len];
        double avg_unstable_arr[]=new double[len];

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
            double probability = getProbability(relays, position);
            if (relays.getRunning()){
                int abw=relays.getAdvertised_bandwidth();
                if (relays.getFlags().contains("Stable")){
                    statistics(abw,probability,ABW_factor,sum_stable_arr,count_stable_arr);
                }else {
                    statistics(abw,probability,ABW_factor,sum_unstable_arr,count_unstable_arr);
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (count_stable_arr[i]!=0) avg_stable_arr[i]=sum_stable_arr[i]/count_stable_arr[i];
            if (count_unstable_arr[i]!=0) avg_unstable_arr[i]=sum_unstable_arr[i]/count_unstable_arr[i];
        }
        for (int i = 0; i < len; i++) {
            System.out.println(i+"\t"+avg_stable_arr[i]+"\t"+avg_unstable_arr[i]);
        }
        reader.endArray();
        reader.close();
    }

    private static void JSON_read_cc(String filePath,int ABW_factor,int len,String position) {
        double sum_de_arr[]=new double[len];
        int count_de_arr[]=new int[len];
        double avg_de_arr[]=new double[len];

        double sum_fr_arr[]=new double[len];
        int count_fr_arr[]=new int[len];
        double avg_fr_arr[]=new double[len];

        double sum_nl_arr[]=new double[len];
        int count_nl_arr[]=new int[len];
        double avg_nl_arr[]=new double[len];

        double sum_us_arr[]=new double[len];
        int count_us_arr[]=new int[len];
        double avg_us_arr[]=new double[len];

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
            double probability = getProbability(relays, position);

            if (relays.getRunning()){
                int abw=relays.getAdvertised_bandwidth();
                String cc=relays.getCountry();
                if (cc==null){
                    break;
                }
                switch (cc){
                    case "de":statistics(abw,probability,ABW_factor,sum_de_arr,count_de_arr);break;
                    case "fr":statistics(abw,probability,ABW_factor,sum_fr_arr,count_fr_arr);break;
                    case "nl":statistics(abw,probability,ABW_factor,sum_nl_arr,count_nl_arr);break;
                    case "us":statistics(abw,probability,ABW_factor,sum_us_arr,count_us_arr);break;
                    default:;break;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (count_de_arr[i]!=0) avg_de_arr[i]=sum_de_arr[i]/count_de_arr[i];
            if (count_fr_arr[i]!=0) avg_fr_arr[i]=sum_fr_arr[i]/count_fr_arr[i];
            if (count_nl_arr[i]!=0) avg_nl_arr[i]=sum_nl_arr[i]/count_nl_arr[i];
            if (count_us_arr[i]!=0) avg_us_arr[i]=sum_us_arr[i]/count_us_arr[i];
        }
        for (int i = 0; i < len; i++) {
            System.out.println(i+"\t"+avg_de_arr[i]+"\t"+avg_fr_arr[i]+"\t"+avg_nl_arr[i]+"\t"+avg_us_arr[i]);
        }
        reader.endArray();
        reader.close();
    }

    private static void JSON_read_as(String filePath,int ABW_factor,int len,String position) {
        double sum_AS200052_arr[]=new double[len];
        int count_AS200052_arr[]=new int[len];
        double avg_AS200052_arr[]=new double[len];

        double sum_AS53667_arr[]=new double[len];
        int count_AS53667_arr[]=new int[len];
        double avg_AS53667_arr[]=new double[len];

        double sum_AS16276_arr[]=new double[len];
        int count_AS16276_arr[]=new int[len];
        double avg_AS16276_arr[]=new double[len];

        double sum_AS396507_arr[]=new double[len];
        int count_AS396507_arr[]=new int[len];
        double avg_AS396507_arr[]=new double[len];

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
//            if ("AS200052".equals(relays.getAs()) && relays.getExit_probability()!=0.0) {
//                System.out.println((int)Math.ceil(relays.getAdvertised_bandwidth()/Math.pow(10,ABW_factor))+"\t"+relays.getExit_probability());
//            }
            double probability = getProbability(relays, position);

            if (relays.getRunning()){
                int abw=relays.getAdvertised_bandwidth();
                String as=relays.getAs();
                if (as==null){
                    break;
                }
                switch (relays.getAs()){
                    case "AS200052":statistics(abw,probability,ABW_factor,sum_AS200052_arr,count_AS200052_arr);break;
                    case "AS16276":statistics(abw,probability,ABW_factor,sum_AS53667_arr,count_AS53667_arr);break;
                    case "AS53667":statistics(abw,probability,ABW_factor,sum_AS16276_arr,count_AS16276_arr);break;
                    case "AS205100":statistics(abw,probability,ABW_factor,sum_AS396507_arr,count_AS396507_arr);break;
                    default:;break;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (count_AS200052_arr[i]!=0) avg_AS200052_arr[i]=sum_AS200052_arr[i]/count_AS200052_arr[i];
            if (count_AS53667_arr[i]!=0) avg_AS53667_arr[i]=sum_AS53667_arr[i]/count_AS53667_arr[i];
            if (count_AS16276_arr[i]!=0) avg_AS16276_arr[i]=sum_AS16276_arr[i]/count_AS16276_arr[i];
            if (count_AS396507_arr[i]!=0) avg_AS396507_arr[i]=sum_AS396507_arr[i]/count_AS396507_arr[i];
        }
        for (int i = 0; i < len; i++) {
            System.out.println(i+"\t"+avg_AS200052_arr[i]+"\t"+avg_AS53667_arr[i]+"\t"+avg_AS16276_arr[i]+"\t"+avg_AS396507_arr[i]);
        }
        reader.endArray();
        reader.close();
    }

    private static void JSON_read_version(String filePath,int ABW_factor,int len,String position) {
        double sum_042_arr[]=new double[len];
        int count_042_arr[]=new int[len];
        double avg_042_arr[]=new double[len];

        double sum_035_arr[]=new double[len];
        int count_035_arr[]=new int[len];
        double avg_035_arr[]=new double[len];

        double sum_041_arr[]=new double[len];
        int count_041_arr[]=new int[len];
        double avg_041_arr[]=new double[len];

        double sum_040_arr[]=new double[len];
        int count_040_arr[]=new int[len];
        double avg_040_arr[]=new double[len];

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
            double probability = getProbability(relays, position);

            if (relays.getRunning()){
                int abw=relays.getAdvertised_bandwidth();
                String v=relays.getVersion().substring(0,6);
                if (v==null){
                    break;
                }
                switch (v){
                    case "0.4.2.":statistics(abw,probability,ABW_factor,sum_042_arr,count_042_arr);break;
                    case "0.3.5.":statistics(abw,probability,ABW_factor,sum_035_arr,count_035_arr);break;
                    case "0.4.1.":statistics(abw,probability,ABW_factor,sum_041_arr,count_041_arr);break;
                    case "0.4.0.":statistics(abw,probability,ABW_factor,sum_040_arr,count_040_arr);break;
                    default:;break;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (count_042_arr[i]!=0) avg_042_arr[i]=sum_042_arr[i]/count_042_arr[i];
            if (count_035_arr[i]!=0) avg_035_arr[i]=sum_035_arr[i]/count_035_arr[i];
            if (count_041_arr[i]!=0) avg_041_arr[i]=sum_041_arr[i]/count_041_arr[i];
            if (count_040_arr[i]!=0) avg_040_arr[i]=sum_040_arr[i]/count_040_arr[i];
        }
        for (int i = 0; i < len; i++) {
            System.out.println(i+"\t"+avg_042_arr[i]+"\t"+avg_035_arr[i]+"\t"+avg_041_arr[i]+"\t"+avg_040_arr[i]);
        }
        reader.endArray();
        reader.close();
    }

    private static void JSON_read_fast(String filePath) {
        Relays relays=null;
        int min=Integer.MAX_VALUE;
        JSONReader reader = null;
        try {
            reader = new JSONReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        reader.startArray();
        while(reader.hasNext()) {
            relays = reader.readObject(Relays.class);

            if (relays.getRunning()){
                if (relays.getFlags().contains("Fast") && relays.getBandwidth_rate()<min){
                    min=relays.getAdvertised_bandwidth();
                }
            }
        }
        System.out.println(min);
        reader.endArray();
        reader.close();
    }
}
