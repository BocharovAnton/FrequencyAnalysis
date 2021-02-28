package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String fileNameIn = args[0];
        String fileNameOut = args[1];
        TreeMap<Character, Float> map = new TreeMap<Character, Float>();
        Integer countOfLetters = 0;
        try(FileReader reader = new FileReader(fileNameIn))
        {
            int c;
            while((c=reader.read())!=-1){
                Character ch = (char) c;
                Character lowCh = Character.toLowerCase(ch);
                if((lowCh>=1072&&lowCh<=1103)||lowCh==1105){
                    countOfLetters++;
                    if(map.containsKey(lowCh)){
                        map.put(lowCh, map.get(lowCh)+1);
                    }
                    else{
                        map.put(lowCh, (float) 1);
                    }
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for (Map.Entry<Character, Float> entry: map.entrySet()) {
            map.put(entry.getKey(),entry.getValue()/countOfLetters);
            System.out.print( entry.getKey()+" ");System.out.print( entry.getValue());
            System.out.println();
        }
        try(FileWriter writer = new FileWriter(fileNameOut, false))
        {
            String text = map.toString();

            writer.write(text);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
