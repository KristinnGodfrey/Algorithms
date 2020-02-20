import edu.princeton.cs.algs4.*;

import java.util.*;

class SortingCalc {

    public static List<String> getRandomList(int num, String[] alphabet) {
        List<String> inList = new ArrayList<String>();
        for (int i = 0; i < num; i++) {
            int rnd = new Random().nextInt(alphabet.length);
            inList.add(alphabet[rnd]);
        }
        return inList;
    }

    public static List<String> getAlphabetized(List<String> tmp, String[] alphabet, int num) {
        for (int i = 0; i < num; i++) {
            String s = (alphabet[i % 25]);
            tmp.add(s);
        }
        return tmp;
    }

    public static List<String> mapReverse(List<String> tmp, String[] alphabet, int num) {
        int remainder;
        for (int i = 0; i < num; i++) {
            remainder = i % 25;

            String s = (alphabet[alphabet.length - remainder-1]);
            tmp.add(s);
        }
        return tmp;
    }

    public static List<String> getSameLetter(List<String> tmp, int num) {
        for (int i = 0; i < num; i++) {            
            tmp.add("A");
        }
        return tmp;
    }

    public static void printArr(String[] array) {
        for (int i = 0; i < array.length; i++) {
            StdOut.println(array[i]);
        }
    }

    public static void measureTime(List<String> inList) {
        String[] rdy = new String[inList.size()];
        inList.toArray(rdy);

        Stopwatch a = new Stopwatch();
        BlackBoxSort.sort1(rdy);
        StdOut.println("sort time of sort1: " + a.elapsedTime());
        Stopwatch b = new Stopwatch();
        BlackBoxSort.sort2(rdy);
        StdOut.println("sort time of sort2: " + b.elapsedTime());
        Stopwatch c = new Stopwatch();
        BlackBoxSort.sort3(rdy);
        StdOut.println("sort time of sort3: " + c.elapsedTime());
        Stopwatch d = new Stopwatch();
        BlackBoxSort.sort4(rdy);
        StdOut.println("sort time of sort4: " + d.elapsedTime());
        // Stopwatch e = new Stopwatch();
        // BlackBoxSort.sort5(rdy);
        // StdOut.println("sort time of sort5: " + f.elapsedTime());
        Stopwatch f = new Stopwatch();
        BlackBoxSort.sort6(rdy);
        StdOut.println("sort time of sort6: " + f.elapsedTime());        
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    

    public static void main(String[] args) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F","G","H", "I", "J", "L", "M", "N","O","P","Q","R","S", "T","U","V","W","X", "Y","Z"};
        StdOut.print("How big sample N? ");
        int num = StdIn.readInt();        

        List<String> inList = new ArrayList<String>();
        inList = getRandomList(num,alphabet);
        // System.out.println(Arrays.toString(inList.toArray()));
        
        while(true) {
        StdOut.println("MENU! press following for functionality:");
        StdOut.println("1 for randomly sorted array:");
        StdOut.println("2 for nearly sorted array");
        StdOut.println("3 for reversly sorted array");
        StdOut.println("4 for sorted array");
        StdOut.print("Choice: ");
        // StdOut.println("4 for few unique elements in array");
        int valmynd = StdIn.readInt();

            switch(valmynd) {
                case 1:
                    inList = getRandomList(num,alphabet);
                    measureTime(inList);
                    break;
               
                case 2:
                    Collections.sort(inList);
                    int rnd = new Random().nextInt(alphabet.length);
                    inList.add(alphabet[rnd]);
                    measureTime(inList);
                    inList.remove(inList.size()/2);
                    break;
                
                case 3:
                    Collections.sort(inList);
                    Collections.reverse(inList); 
                    measureTime(inList);
                    break;

                case 4:
                    Collections.sort(inList);
                    measureTime(inList);
                    break;

                default:
                    StdOut.println("wrong input.");
                   break;
            }
            // System.out.println(Arrays.toString(inList.toArray()));
        }        
    }
}