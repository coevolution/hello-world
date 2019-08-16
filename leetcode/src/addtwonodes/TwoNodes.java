package addtwonodes;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lxp
 * @date 2019/8/12 下午2:32
 * @Version 1.0
 */
public class TwoNodes {
    public static void main(String[] args) throws ClassNotFoundException {
        ListNode n1 = ListNode.listHeadNode(new Integer[]{1,2,3,4,5});
        ListNode n2 = ListNode.listHeadNode(new Integer[]{2,1,7,3});
        ListNode n = addNodeNumber(n1, n2);
        while(n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }
    private static ListNode addNodeNumber(ListNode n1,ListNode n2) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("ListNode.class");
        clazz.getClassLoader().loadClass("ListNode.class");
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode l1 = n1;
        ListNode l2 = n2;

        int flag = 0;
        while(l1 != null || l2 != null) {
            int temp = flag;
            if(l1 != null) {
                temp += l1.value;
                l1 = l1.next;
            }
            if(l2 != null) {
                temp += l2.value;
                l2 = l2.next;
            }
            if(temp >= 10) {
                temp -= 10;
                flag = 1;
            } else {
                flag = 0;
            }
            p.next = new ListNode(temp);
            p = p.next;
        }
        if(flag == 1) {
            p.next = new ListNode(flag);
            p = p.next;
        }

        return dummy.next;
    }
}
