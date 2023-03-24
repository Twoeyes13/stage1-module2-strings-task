package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
//        StringTokenizer list = new StringTokenizer(source, delimiters);
        List<String> listOfSubstrings = new ArrayList<>();
        listOfSubstrings.add(source);
        for (int i = 0; i < delimiters.size(); i++) {
            int currentSize = listOfSubstrings.size();
            for (int j = 0; j < currentSize; j++) {
                String nextWord = listOfSubstrings.get(0);
                listOfSubstrings.remove(nextWord);
                StringTokenizer token = new StringTokenizer(nextWord, delimiters.toArray()[i].toString());
                while (token.hasMoreTokens()) {
                    listOfSubstrings.add(token.nextToken().toString());
                }
            }
        }

//        throw new UnsupportedOperationException("You should implement this method.");
        return listOfSubstrings;
    }
}
