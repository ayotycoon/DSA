package common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return  val +
                " => "+  next;
    }

    public static ListNode create(int[] nums){
        ListNode head = new ListNode(-1);
        ListNode ref = head;
        for(int num: nums){
            ref.next = new ListNode(num);
            ref = ref.next;
        }

        return head.next;

    }
}