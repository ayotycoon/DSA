import java.util.Arrays;

 class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class AddTwoNumbers {
    // 2 Add Two Numbers https://leetcode.com/problems/add-two-numbers

    private static ListNode bruteForce(ListNode l1, ListNode l2) {
         /*
        Time O(m+n)
        Space O(m + n)
         */
        StringBuilder l1Sb = new StringBuilder();
        while (l1 != null) {

            l1Sb.append(l1.val);
            l1 = l1.next;
        }

        StringBuilder l2Sb = new StringBuilder();
        while (l2 != null) {

            l2Sb.append(l2.val);
            l2 = l2.next;
        }
        StringBuilder ansSb = new StringBuilder();

        int carry =0;
        for(int i =0; i < Math.max(l1Sb.length(), l2Sb.length());i++){
            int a = i >= l1Sb.length() ? 0 :Character.getNumericValue(l1Sb.charAt(i));
            int b = i >= l2Sb.length() ? 0 :Character.getNumericValue(l2Sb.charAt(i));
            int add = a+b + carry;

            if(add >= 10){
                carry = 1;
                add = add-10;
            }else {
                carry =0;
            }
            ansSb.append(add);
        }
        if(carry != 0){
            ansSb.append(carry);
        }

        var ans = new ListNode(Character.getNumericValue(ansSb.charAt(0)));
        var ref = ans;
        for(int i =1; i < ansSb.length();i++){

            ref.next = new ListNode(Character.getNumericValue(ansSb.charAt(i)));
            ref = ref.next;
        }

        return ans;
    }

    private static ListNode optimized1(ListNode l1, ListNode l2) {
         /*
        Time O(m+n)
        Space O(m + n)
         */
        ListNode ans =null;
        ListNode ref = null;
        int carry =0;
        while (l1 != null || l2 != null || carry != 0) {
            int a =0;
            int b =0;
            if(l1 != null){
                a = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                b = l2.val;
                l2 = l2.next;
            }
            int add = a+b+carry;
            if(add >= 10){
                carry = 1;
                add = add-10;
            }else {
                carry =0;
            }
            if(ans == null){
                ans = new ListNode(add);
                ref = ans;
            }else {
                ref.next = new ListNode(add);
                ref = ref.next;
            }


        }


        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);

        ListNode bruteForceSolution = bruteForce(l1, l2);
        ListNode optimized1Solution = optimized1(l1, l2);

        System.out.println(bruteForceSolution);
        System.out.println(optimized1Solution);

    }


}
    
    