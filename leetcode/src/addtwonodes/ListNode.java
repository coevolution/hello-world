package addtwonodes;

/**
 * @author lxp
 * @date 2019/8/12 下午2:32
 * @Version 1.0
 */
public class ListNode {
    Integer value;
    ListNode next;

    public ListNode(Integer value) {
        this.value = value;
    }

    public static ListNode listHeadNode(Integer[] integers) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for(Integer i : integers) {
            ListNode l = new ListNode(i);
            p.next = l;
            p = p.next;
        }
        return dummy.next;
    }
}
