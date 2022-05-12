import LeetcodeTestCase.TestCase;
import LeetcodeTestCase.TestCaseExecutor;
import LeetcodeTestCase.TestCaseFunctionGroup;
import common.ListNode;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class SwapNodesInPairs {
    // 24 Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs


    private static ListNode optimized1(ListNode head) {
        /*
        O(N)
         */

        ListNode right = head;
        ListNode left = null;
        ListNode prevLeft = null;
        int i = 0;

        while (right != null) {
            i++;
            if (i % 2 == 0) {
                if (prevLeft != null)  prevLeft.next = right;else head = right;

                ListNode rightNext = right.next;

                right.next = left;
                left.next = rightNext;

                left = right;
                right = right.next.next;




            }else {
                left = right;
                right = right.next;

            }



            if (prevLeft != null) prevLeft = prevLeft.next;
            //if (prevLeft != null) prevLeft = prevLeft.next;
            if (i == 2) prevLeft = head;

        }


        return head;

    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{1, 2, 3, 4}),
                computeTestCase(new int[]{1, 2, 3}),
                computeTestCase(new int[]{1, 2, 3,4,5,6,7,8})


        );

    }

    @NotNull
    private static TestCase computeTestCase(int[] head) {
        return new TestCase(
                "%s ".formatted(
                        Arrays.toString(head)
                ),

/*
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(ListNode.create(nums1), ListNode.create(nums2));
                    return ans != null ? ans.toString() : "";
                }),
                */

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(ListNode.create(head));
                    return ans != null ? ans.toString() : "";
                })
        );
    }


}
    
    