import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import common.ListNode;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class MergeTwoSortedLists{
    // 21 Merge Two Sorted Lists https://leetcode.com/problems/merge-two-sorted-lists

    private static void bruteForce(){
/*        
Time O(1)
 Space O(1)
*/

            
    }
    public static void cleaner(ListNode ans, ListNode node){
        while(node != null){

            ans.next = new ListNode(node.val);
            ans = ans.next;
            node = node.next;

        }

    }
    private static ListNode optimized1(ListNode l1, ListNode l2){
        ListNode _ans = new ListNode(0);
        ListNode ans =_ans;

        while(l1 != null && l2 != null){

            if(l1.val < l2.val){
                ans.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                ans.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            ans = ans.next;
        }

        cleaner(ans, l1);
        cleaner(ans, l2);

        return _ans.next;
            
    }

    public static void main(String[] args){

        new TestCaseExecutor(
                computeTestCase(new int[]{1, 2,  4}, new int[]{1, 3,  4})


        );

    }

    @NotNull
    private static TestCase computeTestCase(int[] nums1,int[] nums2) {
        return new TestCase(
                "%s | %s".formatted(
                        Arrays.toString(nums1),
                        Arrays.toString(nums2)
                ),

/*
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(ListNode.create(nums1), ListNode.create(nums2));
                    return ans != null ? ans.toString() : "";
                }),
                */

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(ListNode.create(nums1), ListNode.create(nums2));
                    return ans != null ? ans.toString() : "";
                })
        );
    }



}
    
    