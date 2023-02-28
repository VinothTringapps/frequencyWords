package org.example;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Frequency {
    public static void main(String[] args) throws FileNotFoundException {
        Logger l =  Logger.getLogger("Frequency");
        Map<String,Integer> words=new HashMap<>();
        CountWord.countWords("\\C:\\Users\\Tringapps-User20\\OneDrive\\Documents\\file.txt",words);
        l.log(Level.INFO,()->" "+ words);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
        Collections.sort(list , new Comparator <Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue()-e1.getValue();
            }
        });
        l.info("Key          Values");
        for (Map.Entry<String, Integer> j: list) {
            l.log(Level.INFO,()->j.getKey()+"     -     "+j.getValue());
        }
    }
}

