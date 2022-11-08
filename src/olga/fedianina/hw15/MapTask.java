package olga.fedianina.hw15;

import java.util.*;

public class MapTask {
    public static List<String> getList(HashMap<String, String> map, String city) {
        ArrayList<String> log = new ArrayList<>();
        for (Map.Entry<String, String> key : map.entrySet()) {
            if (key.getValue().equalsIgnoreCase(city))
                log.add(key.getKey());
        }
        return log;
    }

    public static Map<String, Integer> doobleWord (List<String> list){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i<list.size(); ++i){
            int count = 0;
            for (int j = 0; j<list.size(); ++j){
                if (list.get(j).equalsIgnoreCase(list.get(i))) ++count;
            }
            map.put(list.get(i), count);
        }
        return map;
    }
    public static Map<String, Customer> people (HashMap<String, Customer> map, int from, int to){
        Map<String, Customer> newPeople = new HashMap<>();
        for (Map.Entry<String, Customer> entry : map.entrySet()) {
            if (from <= entry.getValue().getAge() && entry.getValue().getAge() <= to){
                newPeople.put(entry.getKey(), entry.getValue());
            }
        }
        return newPeople;
    }

    public static Map <String, Long> countWords (String text, String word){
        long count =0;
        HashMap<String, Long> res = new HashMap<>();
        String [] textArray = text.split(" ");
        for (int i = 0; i<textArray.length;i++){
            if (textArray[i].equalsIgnoreCase(word)) ++count;
        }
        res.put(word,count);
        return res;

    }

    public static Map <Integer, ArrayList<String>> numberOfWords (String text){
        String [] textArray = text.split(" ");
        Map <Integer, ArrayList<String>> words = new HashMap<>();

        int max = 1;
        for (String string : textArray) {
            if (string.length()>max) max = string.length();
        }
        int wordLenth = 1;
        while (wordLenth<=max){
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i<textArray.length; i++) {
                if (textArray[i].length() == wordLenth){

                    strings.add(textArray[i]);
                }
            }
            words.put(wordLenth, strings);
            wordLenth++;
        }
        return words;
    }



    public static Map<String, Long> occurrence (String text){
        String [] textArray = text.toLowerCase().split(" ");
        HashSet <String> occur = new HashSet<>();
        Map<String, Long> map = new HashMap<>();

        for (String s: textArray) {
            occur.add(s);
        }
        for (String s :occur) {
            long cont = 0;
            for (String s1 : textArray) {
                if (s.equalsIgnoreCase(s1)) cont++;

            }
            map.put(s, cont);
        }
        Map<String, Long> map2 = new HashMap<>();
        long count2 = 0;
        while (count2<10){
            long max = 0;
            String key = "";
            for (String s : map.keySet()) {
                if (max<map.get(s)) {
                    max = map.get(s);
                    key = s;
                }
            }
            map2.put(key,max);
            map.remove(key);
            count2++;
        }
        return map2;
    }


    public static void main(String[] args) {
        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        System.out.println(MapTask.getList(firstTaskMap, "Тверь"));


        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(doobleWord(words));




        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(MapTask.people(customerMap, 22,49));



        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        System.out.println(MapTask.countWords(text, "is"));
        System.out.println(MapTask.numberOfWords(text));
        System.out.println(MapTask.occurrence(text));


    }
}
