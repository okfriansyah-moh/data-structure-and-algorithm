package zero.to.mastery.data_structures.linked_list.hackerrank_case;

import java.util.LinkedList;
import java.util.Scanner;

public class insertHead {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> data = new LinkedList<>();
        int iterasi = 0;
        while(scan.hasNext()) {
            int input = scan.nextInt();
            data.addFirst(input);
            if (iterasi == 0) {
                data.remove(0);
            }
            iterasi++;
        }
        data.forEach(System.out::println);
    }

    /*
    ("%-15s%03d%n", s1, x) % : used as a formatter.
    '-' : minus sign used for left indentation of the string.
    15s : here 15 denotes the string's minimum field width 15.
    '0' : pads the extra 0s in the integer.
    3d : here 3 denotes integer's minimum field width 3.
    %n : prints the new line.
     */
    private void formattingData() {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s%03d%n", s1, x);
        }
        System.out.println("================================");
    }
}
