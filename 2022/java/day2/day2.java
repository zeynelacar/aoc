import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class day2 {

    public static void rockPaperScissors() throws FileNotFoundException {
        int sum1 = 0;
        int sum2 = 0;
        ConcurrentHashMap<String, String> rps = new ConcurrentHashMap<>();
        rps.put("A", "X");
        rps.put("B","Y");
        rps.put("C","Z");

        File file = new File("input-2.txt");
        Scanner scan = new Scanner(file);
        String st = "";
        while (scan.hasNextLine()) {
            st = scan.nextLine();
            String[] tourResult = st.split("\\W+");
            String elf = tourResult[0];
            String first = rps.get(elf);
            String second = tourResult[1];
            sum1 += compareHands(second,first);
            sum2 += compareHandElfWay(second,elf);
        }
        System.out.println("Part 1 : " + sum1);
        System.out.println("Part 2 : " + sum2);
    }

    private static Integer compareHands(String f, String s){
        int result = 0;
        if(!f.equals(s)) {
            switch (f) {
                case "X" -> result = s.equals("Y")? 1:7;
                case "Y" -> result = s.equals("Z")? 2:8;
                case "Z" -> result = s.equals("X")? 3:9;
            }
        }else {
            switch (f) {
                case "X" -> result = 4;
                case "Y" -> result = 5;
                case "Z" -> result = 6;
            }
        }
        return result;
    }

    private static Integer compareHandElfWay(String f,String s){
        int result=0;
        if(!f.equals("Y")) {
            switch (s) {
                case "A" -> result = f.equals("X")? 3:8;
                case "B" -> result = f.equals("X")? 1:9;
                case "C" -> result = f.equals("X")? 2:7;
            }
        }else {
            switch (s) {
                case "A" -> result = 4;
                case "B" -> result = 5;
                case "C" -> result = 6;
            }
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        rockPaperScissors();
    }

}
