import TestSuite.TestCase;
import TestSuite.TestCaseExecutor;
import TestSuite.TestCaseFunctionGroup;
import common.ListNode;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ReverseNodesInKGroup {
    // 25 Reverse Nodes in k-Group https://leetcode.com/problems/reverse-nodes-in-k-group

    private static ListNode optimized1(ListNode head, int k) {
        /*
        O(N)
         */
        if(head == null || k==1)
            return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy,nex=dummy,pre=dummy;
        int count=0;
        while(curr.next!=null)
        {
            curr=curr.next;
            count++;
        }
        while(count>=k)
        {
            curr=pre.next;
            nex=curr.next;
            for(int i=1;i<k;i++)
            {
                curr.next=nex.next;
                nex.next=pre.next;
                pre.next=nex;
                nex=curr.next;
            }
            pre=curr;
            count-=k;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        new TestCaseExecutor(
                computeTestCase(new int[]{1, 2, 3,4,5,6}, 3)
                //  computeTestCase(new int[]{1, 2, 3,4,5},3)


        );

    }

    @NotNull
    private static TestCase computeTestCase(int[] head, int k) {
        return new TestCase(
                "%s | %d".formatted(
                        Arrays.toString(head), k
                ),

/*
                new TestCaseFunctionGroup("bruteForce", () -> {
                    var ans = bruteForce(ListNode.create(nums1), ListNode.create(nums2));
                    return ans != null ? ans.toString() : "";
                }),
                */

                new TestCaseFunctionGroup("optimized1", () -> {
                    var ans = optimized1(ListNode.create(head), k);
                    return ans != null ? ans.toString() : "";
                })
        );
    }


}
    
    