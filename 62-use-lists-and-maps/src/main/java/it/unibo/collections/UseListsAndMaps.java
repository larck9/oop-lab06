package it.unibo.collections;

import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }
    private static final int ELEMS = 1_000_000;
    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> arlist=new ArrayList<>();
         
        
         for(int i=1000;i<2000;i++){
            arlist.add(i);
         }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

         List<Integer> lilist =new LinkedList<>(arlist);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
         
         Integer tmp = arlist.get(arlist.size()-arlist.size());
         arlist.set(arlist.size()-arlist.size(), arlist.getLast());
         arlist.set(arlist.indexOf(arlist.getLast()),tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for(Integer e:arlist){
            System.out.println(e);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long test1 = System.nanoTime();
        
         for(int i=0;i<ELEMS;i++){
        arlist.addFirst(i);
        }
    
        test1 = System.nanoTime() - test1;
        final long test1millis =TimeUnit.NANOSECONDS.toMillis(test1);
        
        
        
        long test2 = System.nanoTime();

        for(int i=0;i<ELEMS;i++){
        lilist.addFirst(i);
        }

        test2 = System.nanoTime() - test2;
        final long test2millis = TimeUnit.NANOSECONDS.toMillis(test2);


        System.out.println("test con array list "+ test1 +"ns"+ test1millis +"ms"); 
        System.out.println("test con linked list "+ test2 +"ns"+ test2millis +"ms");       //linked list molto piu performanti per aggiungere elementi

        
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

         long test1b = System.nanoTime();
        
         for(int i=0;i<1000;i++){
        System.out.print(arlist.get(i));
        }
    
        test1b = System.nanoTime() - test1b;
        final long test1bmillis =TimeUnit.NANOSECONDS.toMillis(test1b);
        
        
        
        long test2b = System.nanoTime();

        for(int i=0;i<1000;i++){
        System.out.print(lilist.get(i));
        }

        test2b = System.nanoTime() - test2b;
        final long test2bmillis = TimeUnit.NANOSECONDS.toMillis(test2b);


        System.out.println("test con array list "+ test1b +"ns"+ test1bmillis +"ms");    //arraylist piu performanti per la lettura rispetto alle linked list
        System.out.println("test con linked list "+ test2b +"ns"+ test2bmillis +"ms");       


        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        
        Map<String,Long> population= new HashMap<>();
        population.put("Africa",1_110_635_000L);
        population.put("Americas",972005000L);
        population.put("Antartica",0L);
        population.put("Asia",4_298_723_000L);
        population.put("Europe",742452000L);
        population.put("Oceania",38304000L);
         /*
         * 8) Compute the population of the world
         */
        long sum=0;
        for(String key:population.keySet()){
           sum+=population.get(key);
        }
        System.out.println(sum);
    
    
        }   
}
