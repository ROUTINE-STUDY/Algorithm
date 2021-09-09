class Solution {
    public boolean isUnivalTree(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList();
        
        int rootnum = root.val;
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                if(node.val != rootnum){
                    return false;
                }
                if(node.left != null){q.offer(node.left);}
                if(node.right != null){q.offer(node.right);}
            }
        }
        
        return true;
    }
}

// 2

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList();
        HashSet<Integer> hs = new HashSet();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                hs.add(node.val);
                if(node.left != null){q.offer(node.left);}
                if(node.right != null){q.offer(node.right);}
            }
        }
        
        return (hs.size() > 1) ? false : true;
    }
}
