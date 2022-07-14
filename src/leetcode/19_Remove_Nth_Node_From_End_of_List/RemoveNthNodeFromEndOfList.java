import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import common.ListNode;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class RemoveNthNodeFromEndOfList {
    // 19 Remove Nth Node From End of List https://leetcode.com/problems/remove-nth-node-from-end-of-list

    private static ListNode bruteForce(ListNode head, int n) {
        return head;


    }

    private static ListNode optimized1(ListNode head, int n) {
        /*
        Time O(N)
        space O(N)
         */
        if (head == null) return null;
        int len = 0;


        ListNode ref = head;
        //  get the node length
        while (ref != null) {
            len++;
            ref = ref.next;
        }

        int indexFromHead = len - n;

        int index = 0;
        ref = head;
        ListNode prev = null;
        while (ref != null) {
            if (index == indexFromHead) {
                if (prev == null) return head.next;
                prev.next = ref.next;
            }

            index++;
            prev = ref;
            ref = ref.next;

        }

        return head;

    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{1, 2, 3, 4, 5}, 2),
                computeTestCase(new int[]{1}, 1),
                computeTestCase(new int[]{3, 5, 2, 7}, 4)


        );

    }


    @NotNull
    private static TestCase computeTestCase(int[] nums, int n) {
        return new TestCase(
                "%s | %s".formatted(
                        Arrays.toString(nums),
                        String.valueOf(n)),

                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(ListNode.create(nums), n);
                    return ans != null ? ans.toString() : "";
                }),

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(ListNode.create(nums), n);
                    return ans != null ? ans.toString() : "";
                })
        );
    }


}
    
    