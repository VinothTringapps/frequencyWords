package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountWord {
    static void countWords(String fileName, Map<String, Integer> words) throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNext()) {
            String word = file.next();

            Integer count = words.get(word);
            if (count != null)
                count++;
            else
                count = 1;
            words.put(word, count);
        }
        file.close();
    }
}