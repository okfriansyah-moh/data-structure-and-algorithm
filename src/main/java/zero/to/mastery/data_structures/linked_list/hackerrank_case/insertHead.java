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

    /*
    sample input :
        2
        0 2 10
        5 3 5

    sample output :
        2 6 14 30 62 126 254 510 1022 2046
        8 14 26 50 98
     */
    private void exponential() {
        Scanner scanner = new Scanner(System.in);
        int queryLength = scanner.nextInt();
        for (int i = 0; i < queryLength; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int secondQlength = scanner.nextInt();
            int result = a;
            for (int j = 0; j < secondQlength; j++) {
                result += Math.pow(2, j) * b;
                System.out.printf("%s " , result);
            }
            System.out.println();
        }
        scanner.close();
    }
}
