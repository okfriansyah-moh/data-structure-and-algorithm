package zero.to.mastery;

import java.util.ArrayList;
import java.util.List;

public class SplitTheArrayEqualSum {

    /** You are Given an array consisting of n positive integers.
        Print Yes if there is a place to split the array so that the sum
        of the elemets on one side is equal to the sum of the elements on
        the other side. Otherwise , print No.
     **/
    public String solve(List<Integer> ar) {
        int p1 = 0; // a pointer to start of array
        int p2 = ar.size()-1; // a pointer to end of array
        int sum1=0;// sum1 for left side elements sum taken care by p1
        int sum2=0;// sum2 for right side elements sum taken care by p2
        for(int i=0;i<ar.size();i++){
            //run upto the length of array

            sum1+= ar.get(p1); // summing left side elements
            sum2+=ar.get(p2);//adding right side elements
            System.out.println("sum1 = " + sum1);
            System.out.println("sum2 = " + sum2);
            System.out.println("p1 = " + p1);
            System.out.println("p2 = " + p2);
            System.out.println("math abs = " + Math.abs(p1-p2));
            if(sum1==sum2 && Math.abs(p1-p2) == 1){
                //if two sums become equal and the pointers differ by only one position
                //then we got the answer
                return "YES";
            }
            if(sum1 == sum2){
                //two sums are equal means elements are equal on both sides
                //hence move both pointers
                p1++;
                p2--;
                System.out.println("sum1 = " + sum1);
                System.out.println("sum2 = " + sum2);
                System.out.println("p1 = " + p1);
                System.out.println("p2 = " + p2);
            }
            else if(sum1 > sum2){
                // sum1 is greater then need to make sum2 bigger hence move p2
                p2--;
                sum1-= ar.get(p1);//removing repeated addition when p2 is changed
                System.out.println("sum1 = " + sum1);
                System.out.println("p2 = " + p2);
            }
            else{
                // sum2 is greater then need to make sum1 bigger hence move p1
                p1++;
                sum2-=ar.get(p2);//removing repeated addition when p1 is changed
                System.out.println("sum2 = " + sum2);
                System.out.println("p1 = " + p1);
            }

        }
        return "NO";
    }

    public static void main(String[] args) {
        SplitTheArrayEqualSum splitTheArray = new SplitTheArrayEqualSum();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(2);
        System.out.println(splitTheArray.solve(a));
    }
}
