package LinkedList.Merge_Two_Sorted_Lists;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Sanghoo {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        LinkedList<ListNode> linkedList = new LinkedList<>();

        // LinkedList에 각각의 Node를 담기
        while(l1 != null) {
            linkedList.add(l1);
            l1 = l1.next;
        }

        while(l2 != null) {
            linkedList.add(l2);
            l2 = l2.next;
        }

        // 값을 기준으로 정렬
        linkedList.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val > o2.val) return 1;
                else if(o1.val < o2.val) return -1;
                return 0;
            }
        });

        // return 객체 생성
        ListNode tempNode = new ListNode();
        ListNode res = tempNode;

        for(ListNode node : linkedList) {
            tempNode.next = node;
            tempNode = tempNode.next;
        }

        return res.next;
    }


}
