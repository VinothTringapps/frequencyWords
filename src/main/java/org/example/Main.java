package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.*;
public class Main
{
    static void countWords(String fileName, Map<String, Integer> words) throws FileNotFoundException {
        Scanner file=new Scanner (new File(fileName));
        while(file.hasNext()){
            String word=file.next();
            Integer count=words.get(word);
            if(count!=null)
                count++;
            else
                count=1;
            words.put(word,count);
        }
        file.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
         Logger l =  Logger.getLogger("Frequency");
        Map<String,Integer> words=new HashMap<>();
        countWords("\\C:\\Users\\Tringapps-User20\\OneDrive\\Documents\\file.txt",words);
        l.log(Level.INFO,()->" "+ words);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
        Collections.sort(list , new Comparator <Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue()-e1.getValue();
            }
        });
        l.info("Key          Values");
    for (Entry<String, Integer> j: list) {
            l.log(Level.INFO,()->j.getKey()+"     -     "+j.getValue());
        }
    }
}