import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class day3 {

    public static void rucksacks() throws FileNotFoundException {
        int sum1 = 0;
        int sum2 = 0;
        File file = new File("input-3.txt");
        Scanner scan = new Scanner(file);
        String st = null;
        List<String> words = new ArrayList<>();
        while (scan.hasNextLine()) {
            st = scan.nextLine();
            sum1 += partOne(st);
            words.add(st);
            sum2 += words.size() == 3 ?partTwo(words): 0;
            if (words.size()==3)
                words.clear();
        }
        System.out.println("Part 1 : " + sum1);
        System.out.println("Part 2 : " + sum2);
    }

    private static int partOne(String st){
        int res = 0;
        HashSet<Character> charSet1 = new HashSet<>();
        HashSet<Character> charSet2 = new HashSet<>();
        int half = st.length()/2;
        String pack1 = st.substring(0,half);
        String pack2 = st.substring(half);
        pack1.chars().mapToObj(c -> (char) c).forEach(charSet1::add);
        pack2.chars().mapToObj(c -> (char) c).forEach(charSet2::add);
        charSet1.retainAll(charSet2);
        char common = charSet1.toArray()[0].toString().charAt(0);
        res = Character.isLowerCase(common)? (int) common - (int ) 'a' + 1 : (int) common - (int) 'A' + 27 ;
        return res;
    }

    private static int partTwo(List<String> list){
        int res = 0;
        String word1 = list.get(0);
        String word2 = list.get(1);
        String word3 = list.get(2);
        HashSet<Character> charSet1 = new HashSet<>();
        HashSet<Character> charSet2 = new HashSet<>();
        HashSet<Character> charSet3 = new HashSet<>();
        word1.chars().mapToObj(c -> (char) c).forEach(charSet1::add);
        word2.chars().mapToObj(c -> (char) c).forEach(charSet2::add);
        word3.chars().mapToObj(c -> (char) c).forEach(charSet3::add);
        charSet1.retainAll(charSet2);
        charSet1.retainAll(charSet3);
        char common = charSet1.toArray()[0].toString().charAt(0);
        res = Character.isLowerCase(common)? (int) common - (int ) 'a' + 1 : (int) common - (int) 'A' + 27 ;
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException {
        rucksacks();
    }

}
