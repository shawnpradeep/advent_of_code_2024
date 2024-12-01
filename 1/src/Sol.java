import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Sol {
    public static void main(String[] args) {
        try {
            File file = new File("1/input.txt");
            Scanner scanner = new Scanner(file);
            // int sol = partOne(scanner);
            int sol = partTwo(scanner);

            System.out.println("Answer: " + sol);
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } //try
    } //main

    private static int partOne(Scanner scanner) {
        PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>();

        while (scanner.hasNextLine()) {
            heap1.offer(scanner.nextInt());
            heap2.offer(scanner.nextInt());
        } //while

        int sol = 0;
        while (!heap1.isEmpty()) {
            int diff = Math.abs(heap1.poll() - heap2.poll());
            sol += diff;
        }

        return sol;
    }

    private static int partTwo(Scanner scanner) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> c1 = new ArrayList<>();

        while (scanner.hasNextLine()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            c1.add(a);
            if (!freq.containsKey(b)) {
                freq.put(b, 0);
            }

            freq.put(b, freq.get(b) + 1);
        } //while

        int sol = 0;
        for (int e : c1) {
            if (freq.containsKey(e)) sol += e * freq.get(e);
        } //for-each

        return sol;
    } //partTwo

} //Sol