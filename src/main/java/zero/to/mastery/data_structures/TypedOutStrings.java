package zero.to.mastery.data_structures;

import java.util.ArrayList;
import java.util.List;

public class TypedOutStrings {

    // using two pointer technique
    public boolean backspaceCompare2(String s, String t) {
        int p1 = s.length() - 1, p2 = t.length() - 1;
        String resultP1 = pointerWhile(p1, s);
        String resultP2 = pointerWhile(p2, t);
        System.out.println("result p1 = " + resultP1 + " result p2 = " + resultP2);
        return resultP1.equals(resultP2);
    }

    private String pointerWhile(int p, String data) {
        String result = "";
        while (p >= 0) {
            if ('#' != data.charAt(p))  {
                result += data.charAt(p);
                p--;
            } else {
                int nBackWard = 2;
                while (nBackWard > 0) {
                    nBackWard--;
                    p--;
                    if (p >= 0 && data.charAt(p) == '#') {
                        nBackWard = nBackWard + 2;
                    }
                }
            }
        }
        return result;
    }

    public boolean backspaceCompare(String s, String t) {
        List<String> finalS = buildString(s);
        List<String> finalT = buildString(t);
        if (finalS.size() != finalT.size()) {
            return false;
        } else {
            for (int p = 0; p < finalS.size(); p++) {
                System.out.println("Final S = " + finalS.get(p));
                System.out.println("Final T = " + finalT.get(p));
                if (!finalS.get(p).equals(finalT.get(p))) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> buildString(String s) {
        List<String> builtArray = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                builtArray.add(String.valueOf(s.charAt(i)));
                System.out.println("Add to builtArray " + builtArray);
            } else {
                System.out.println("Remove the builtArray " + builtArray);
                System.out.println("index = " + i);
                if (builtArray.size() > 0) {
                    builtArray.remove(builtArray.size() - 1);
                }
            }
        }
        return builtArray;
    }

    public static void main(String[] args) {
        TypedOutStrings typedOutStrings = new TypedOutStrings();
        String c =  "ab#c";
        String d = "ad#c";
        String s = "ab##";
        String t = "c#d#";
        String a = "a##c";
        String b = "#a#c";
        String x = "abc#d";
        String y = "abzz##d";
        String e = "xywrrmp";
        String f = "xywrrmu#p";
        String z = "bxj##tw";
        String u = "bxj###tw";
        String g = "bxj##tw";
        String h = "bxo#j##tw";
        typedOutStrings.backspaceCompare2(e,f);
//        System.out.println();
    }
}
