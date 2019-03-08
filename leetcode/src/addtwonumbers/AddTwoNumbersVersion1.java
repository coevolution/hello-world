package addtwonumbers;

public class AddTwoNumbersVersion1 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode r = new ListNode(0);
        ListNode t = r;
        int extra = 0;
        int sum = 0;
        while (n1 != null || n2 != null) {
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }

            t.next = new ListNode(sum % 10);
            t = t.next;
            if ((extra = sum / 10) > 0) {
                sum = 1;
            } else {
                sum = 0;
            }
        }
        if (sum == 1) {
            t.next = new ListNode(sum);
        }
        return r.next;
    }

    /**
     * @param i 正整数
     * @return
     */
    public ListNode convert(int i) {
        ListNode r = new ListNode(0);
        ListNode tempNode = r;
        while (i > 0) {
            int temp = i % 10;
            ListNode n = new ListNode(temp);
            tempNode.next = n;
            tempNode = tempNode.next;
            i /= 10;
        }
        return r.next;
    }
}
