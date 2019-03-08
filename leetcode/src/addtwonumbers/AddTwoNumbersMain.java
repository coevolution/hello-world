package addtwonumbers;

import java.util.Random;

public class AddTwoNumbersMain {
    public static void main(String[] args) {
        AddTwoNumbersVersion1 v1 = new AddTwoNumbersVersion1();
        int s = new Random().nextInt(1000);
//        int s =40;
        System.out.println(s);
        int c = new Random().nextInt(1000);
        System.out.println(c);

//        AddTwoNumbersVersion1.ListNode node = v1.convert(s);
//        AddTwoNumbersVersion1.ListNode printNode = node;
//        while(printNode != null) {
//            System.out.print(printNode.val);
//            printNode = printNode.next;
//        }
//        System.out.println();

        AddTwoNumbersVersion1.ListNode result =  v1.addTwoNumbers(v1.convert(s),v1.convert(c));
        AddTwoNumbersVersion1.ListNode printResult = result;
        while(printResult != null) {
            System.out.print(printResult.val);
            printResult = printResult.next;
        }
    }
}
