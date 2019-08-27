package testmonth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeMap;

/**
 * Created by tiantian on 2019/8/26.
 */
public class ReadAndAlibaba {

    public static void display()throws Exception{

        File file=new File("文件路径");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        //定义一个map集合保存单词和单词出现的个数
        TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
        //读取文件
        while((line=br.readLine())!=null){

            line.toLowerCase();
            String reg1 = "\\s+";
            String reg2 ="\\w+";
            //将读取的文本进行分割
            String str[] = line.split(reg1);
            for(String s: str){
                if(s.matches(reg2)){
                    //判断集合中是否已经存在该单词，如果存在则个数加一，否则将单词添加到        //集合中，且个数置为1
                    if(!tm.containsKey(s)){
                        tm.put(s,1);
                    }else{
                        tm.put(s,tm.get(s)+1);
                    }
                }
            }
        }
        System.out.println(tm);
    }
}
