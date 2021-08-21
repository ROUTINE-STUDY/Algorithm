/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){return true;} // 같으면 둘 다 null true
        
        ArrayList<Integer> pArr = new ArrayList();
        ArrayList<Integer> qArr = new ArrayList();
        
        Stack<TreeNode> pstack = new Stack();
        Stack<TreeNode> qstack = new Stack();
        
        TreeNode pcur = p;
        TreeNode qcur = q;
        while(pcur != null || qcur != null || !pstack.isEmpty() || !qstack.isEmpty()){
            while(pcur != null || qcur != null){
                if(pcur == null && qcur != null){
                    return false;
                }else if(pcur != null && qcur == null){
                    return false;
                }
                pstack.add(pcur);
                qstack.add(qcur);
                pcur = pcur.left;
                qcur = qcur.left;
            }
            pcur = pstack.pop();
            qcur = qstack.pop();
            pArr.add(pcur.val);
            qArr.add(qcur.val);
            pcur = pcur.right;
            qcur = qcur.right;
        }
        
        if(!Arrays.equals(pArr.toArray(),qArr.toArray())){
            return false;
        }
        
        return true;
    }
}