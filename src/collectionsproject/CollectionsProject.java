/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author rafael
 */
public class CollectionsProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // First collection
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Collections.shuffle(list, new Random());

        // Second collection 
        List<Integer> anotherList = new ArrayList<>();
        for (int i = 6; i <= 15; i++) {
            anotherList.add(i);
        }

        Collections.shuffle(anotherList, new Random());
        //System.out.println(anotherList);

        // print each element to the console using method references
        list.forEach(System.out::print);
        System.out.println("  Collection 1 size = " + list.size());
        anotherList.forEach(System.out::print);
        System.out.println("  Collection 2 size = " + anotherList.size());

        Set<Integer> set = new HashSet<>(list);
        set.addAll(anotherList);
        List<Integer> mergeList = new ArrayList<>(set);

        int s = mergeList.size();
        int x = (s / 2) + 1;
        //remove middle element
        mergeList.remove(x);

        int size = mergeList.size();
        ListIterator li = mergeList.listIterator(size);

        // Iterate in reverse.
        while (li.hasPrevious()) {
            System.out.print(li.previous());
        }

        System.out.println("  Merged collection size = " + size+"\n");

        // Create a hash map
        Map<String, Integer> map = new HashMap<>();
        // Put elements to the map
        map.put("Value1", 11);
        map.put("Value2", 22);
        map.put("Value3", 33);
        map.put("Value4", 44);
        map.put("Value5", 55);

        String key = "Value3";

        if (map.containsKey(key)) {
            System.out.println("Duplicate key and value");
            System.out.print(key + ": ");
            System.out.print(map.get(key) + "\n");
        }
        // Get a set of the entries
        Set setMap = map.entrySet();
        // Get an iterator
        Iterator i = setMap.iterator();
        System.out.println("Keys and values:");
        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());

        }
        System.out.println("Size: "+map.size());

        
        /**
         *  Why was HashMap chosen?
         * 
         * Since the requirements did not specify if keys should be
         * sorted, HashMap is a clean and safe way of associating keys and values.
         * Also as the requirement only specify 5 key/values should be added, there
         * are no issues with nulls being inserted.
         */
    }

}
