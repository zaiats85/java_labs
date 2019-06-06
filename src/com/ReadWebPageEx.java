package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWebPageEx {

    /*Here's a generic-friendly version:*/
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    // Function to sort map by Key
    public static <K, V extends Comparable<? super V>> Map<K, V> sortbykey(Map<K, V> map) {
        // TreeMap to store values of HashMap
        TreeMap<K, V> sorted = (TreeMap<K, V>) new TreeMap<K, V>(map);

        Map<K, V> result = new LinkedHashMap<>();
        // Display the TreeMap which is naturally sorted
        for (Map.Entry<K, V> entry : sorted.entrySet()){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        BufferedReader br = null;
        try {
            URL url = new URL("http://www.something.com");
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            HashMap<String, Integer> st = new HashMap<>();

            /*Form a String*/
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            /*Match tags only*/
            Pattern p = Pattern.compile("<([^\\s>/]+)");
            Matcher m = p.matcher(sb);

            int distinct = 0, words = 0;

            while(m.find()) {
                String tag = m.group(1);
                // compute frequency counts
                words++;
                if (st.containsKey(tag)) {
                    st.put(tag, st.get(tag) + 1);
                } else {
                    st.put(tag, 1);
                    distinct++;
                }
            }

            System.out.println(st);
            System.out.printf("Distinct tags %d \n",distinct);
            System.out.printf("All tags %d \n", words);

            System.out.println(sortByValue(st));;
            System.out.println(sortbykey(st));

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
