import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import common.ListNode;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MergeKSortedLists {
    // 23 Merge k Sorted Lists https://leetcode.com/problems/merge-k-sorted-lists

    private static ListNode bruteForce(ListNode[] lists) {

return null;
    }

    private static ListNode optimized1(ListNode[] lists) {
        /*
        Time O(N)
        Memory O(N)
         */
        ListNode ans = new ListNode(Integer.MIN_VALUE);
        ListNode ref = ans;


        while (true) {
            int lowestIndex = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node == null) continue;
                if (lowestIndex == Integer.MAX_VALUE) {
                    lowestIndex = i;
                } else {
                    if (node.val < lists[lowestIndex].val  ) lowestIndex = i;
                }
            }
            if (lowestIndex == Integer.MAX_VALUE) break;

            ref.next = new ListNode(lists[lowestIndex].val);

            lists[lowestIndex] = lists[lowestIndex].next;
            ref = ref.next;


        }

        return ans.next;

    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[][]{
                        new int[]{1, 4, 5},
                        new int[]{1, 3, 4},
                        new int[]{2, 6}
                }) ,

                computeTestCase(new int[][]{
                        new int[]{1, 6, 7},
                        new int[]{-9, 3, 99},
                        new int[]{1,4, 7,8}
                }),
                computeTestCase(new int[][]{
                        new int[]{},
                        new int[]{},
                        new int[]{}
                })


        );

    }

    @NotNull
    private static TestCase computeTestCase(int[][] nums) {
        return new TestCase(
                "%s ".formatted(
                        Arrays.toString(Arrays.stream(nums).map(lists -> Arrays.toString(lists)).toArray(String[]::new))
                ),

/*
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(ListNode.create(nums1), ListNode.create(nums2));
                    return ans != null ? ans.toString() : "";
                }),
                */

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(Arrays.stream(nums).map(lists -> ListNode.create(lists)).toArray(ListNode[]::new));
                    return ans != null ? ans.toString() : "";
                })
        );
    }


}
    
    