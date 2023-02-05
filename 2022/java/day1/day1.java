import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class day1 {

    public static void calculateElfCalories() throws IOException {
        ConcurrentHashMap<String,Long> elfMap = new ConcurrentHashMap<>();
        String elfName = "";
        long elfCalories = 0L;
        int elfNumber = 0;

        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String st = null;
        while (scan.hasNextLine()) {
            st = scan.nextLine();
            if(!st.isEmpty()) {
                elfCalories += Long.parseLong(st);
            }else {
                elfNumber += 1;
                elfName = "elf" + elfNumber;
                elfMap.put(elfName,elfCalories);
                elfCalories = 0L;
            }
        }
        Optional<Map.Entry<String, Long>> bestElf = elfMap.entrySet().stream().max(Map.Entry.comparingByValue());
        Long maxCal = bestElf.get().getValue();
        System.out.println(maxCal);

    }

    public static void calculateElfCalorie() throws IOException {
        ArrayList<Long> calories = new ArrayList<>();
        long cal = 0L;

        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        String st = null;
        while (scan.hasNextLine()) {
            st = scan.nextLine();
            if(!st.isEmpty()) {
                cal += Long.parseLong(st);
            }else {
                calories.add(cal);
                cal = 0L;
            }
        }
        List<Long> sorted = calories.stream().sorted(Comparator.reverseOrder()).toList();
        long ans1 = sorted.get(0);
        long ans2 = sorted.get(0)+ sorted.get(1)+ sorted.get(2);
        System.out.println("part 1:" + ans1);
        System.out.println("part 2:" + ans2);

    }

    public static void main(String[] args) throws IOException {
        calculateElfCalorie();
    }


}
