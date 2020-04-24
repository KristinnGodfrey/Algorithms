/******************************************************************************
 *  Compilation:  javac Counter.java
 *  Execution:    java Counter n trials
 *  Dependencies: StdRandom.java StdOut.java
 *
 *  A mutable data type for an integer counter.
 *
 *  The test clients create n counters and performs trials increment
 *  operations on random counters.
 *
 * java Counter 6 600000
 *  100140 counter0
 *  100273 counter1
 *  99848 counter2
 *  100129 counter3
 *  99973 counter4
 *  99637 counter5
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.*; 

class Counter implements Comparable<Counter>{
    private final String name;     // counter name
    private int count = 0;         // current value

    public Counter(String id) {
        name = id;
    } 

    public void increment() {
        count++;
    }

    //public int tally()

    public String toString() {
        return count + " " + name;
    }

    @Override
    public int compareTo(Counter that) {
        if      (this.count < that.count) return -1;
        else if (this.count > that.count) return +1;
        else                              return  0;
    }
    

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        //create n counters
        Counter[] hits = new Counter[n];
        for (int i = 0; i < n; i++) {
            hits[i] = new Counter("counter" + i);
        }

        //increment one of our counters picked at random
        for (int t = 0; t < trials; t++) {
            hits[StdRandom.uniform(n)].increment();
        }

        for (int i = 0; i < n; i++) {
            StdOut.println(hits[i]);
        }
    }
}