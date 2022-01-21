package zero.to.mastery.data_structures;

import java.util.ArrayList;
import java.util.List;

public class TypedOutStrings {
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
        String s = "ab##";
        String t = "c#d#";
        String a = "a##c";
        String b = "#a#c";
        System.out.println(typedOutStrings.backspaceCompare(a,b));
    }
}
