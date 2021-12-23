package zero.to.mastery.data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayPay {

    static int[] numbers = {0,1,2,3,4,5,6,7,8,9};
//    int[] solution(int[] a) {
//        HashMap<String,Integer> mapData = new HashMap<>();
//        mapData.put(numbers[0],0);
//        mapData.put(numbers[1],0);
//        mapData.put(numbers[2],0);
//        mapData.put(numbers[3],0);
//        mapData.put(numbers[4],0);
//        mapData.put(numbers[5],0);
//        mapData.put(numbers[6],0);
//        mapData.put(numbers[7],0);
//        mapData.put(numbers[8],0);
//        mapData.put(numbers[9],0);
//        int[] result = {};
//        for (int i = 0; i < a.length; i++) {
//            String aData = String.valueOf(a[i]);
//            System.out.println("aData " + aData);
//            int countNumbersAppears = 0;
//            for (String key : mapData.keySet()) {
//
//                System.out.println("Key " + key);
//                if (key.contains(aData)) {
//                    countNumbersAppears++;
//
//                    System.out.println("Appears " + countNumbersAppears);
//                }
//                int totalValue = mapData.get(key) + countNumbersAppears;
//                mapData.put(key,totalValue);
//            }
//        }
//        System.out.println(mapData);
//
//        return result;
//    }
//
//    int solution(String beginWord, String endWord, String[] wordList) {
//        List<String> wordListArray = Arrays.asList(wordList);
//        if (beginWord.equals(endWord)) return 1;
//        Set<String> wordListToSet = new HashSet<>(wordListArray);
//        Queue<String> queingWord = new LinkedList<>();
//        queingWord.offer(beginWord);
//        int steps = 1;
//        while (!queingWord.isEmpty()) {
//            int level = queingWord.size();
//            for (int i = 0; i < level; i++) {
//                char[] letters = queingWord.poll().toCharArray();
//                for(int j = 0; j < letters.length; j++) {
//                    char prevChar = letters[j];
//                    for (char ch = 'a'; ch <= 'z'; ch++) {
//                        letters[j] = ch;
//                        String nextWord = new String(letters);
//                        if (wordListToSet.contains(nextWord)) {
//                            if (nextWord.equals(endWord)) {
//                                return steps + 1;
//                            }
//                            queingWord.offer(nextWord);
//                            wordListToSet.remove(nextWord);
//                        }
//                    }
//                    letters[j] = prevChar;
//                }
//            }
//            steps++;
//        }
//        return 0;
//    }
//
//
//    int[] solution(int[] a) {
//        HashMap<Integer, Integer> hm = new HashMap<>();
//
//        for(int i : a){
//            hm.put(i, hm.getOrDefault(i, 0) + 1);
//        }
//
//
//        List<Entry<Integer, Integer>> list_entires = new ArrayList<>(hm.entrySet());
//
//        Collections.sort(list_entires, new Comparator<Entry<Integer, Integer>>(){
//
//            public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2){
//
//                if(obj1.getValue() == obj2.getValue()){
//                    return obj2.getKey().compareTo(obj1.getKey());
//                }
//                else{
//                    return obj1.getValue().compareTo(obj2.getValue());
//                }
//            }
//        });
//
//        int[] ans = new int[nums.length];
//
//        int j = 0;
//        for(Entry<Integer, Integer> entry : list_entires) {
//            for(int i = 0; i < entry.getValue(); i++){
//                ans[j] = entry.getKey();
//                j++;
//            }
//        }
//
//
//        return ans;
//    }


    public static int[] solution(int[] a) {
        Map<Integer, Integer> mp
                = new HashMap<Integer, Integer>();

        // Put count of all the
        // distinct elements in Map
        // with element as the key &
        // count as the value.
        for (int i = 0; i < a.length; i++) {

            // Get the count for the
            // element if already present in the
            // Map or get the default value which is 0.
            mp.put(a[i],
                    mp.getOrDefault(a[i], 0) + 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list
                = new ArrayList<Map.Entry<Integer,
                Integer> >(
                mp.entrySet());

        // Sort the list
        Collections.sort(
                list,
                new Comparator<Map.Entry<Integer,
                                        Integer> >()
                {
                    public int compare(
                            Map.Entry<Integer, Integer> o1,
                            Map.Entry<Integer, Integer> o2)
                    {
                        if (o1.getValue() == o2.getValue())
                            return o2.getKey() - o1.getKey();
                        else
                            return o2.getValue()
                                    - o1.getValue();
                    }
                });

        for (int i = 0; i < numbers.length; i++)
            System.out.println(list.get(i).getKey());
        int[] result = {1,3};
        return result;
    }

    public static void main(String[] args) {
        int[] a = {25,2,3,57,38,41};
        System.out.println(solution(a));
    }




}
