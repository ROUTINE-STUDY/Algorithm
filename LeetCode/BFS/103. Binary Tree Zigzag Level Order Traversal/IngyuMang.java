class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new LinkedList<>();//배열 끝에 추가라 LinkedList가 빠를 듯?
        Deque<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            boolean isPollFirst = false;
            queue.offer(root);
            answer.add(new ArrayList<>());
            answer.get(0).add(root.val);

            while (!queue.isEmpty()) {
                int size = queue.size();
                Deque<Integer> deque = new LinkedList<>();

                while (size-- > 0) {
                    TreeNode temp = queue.poll();

                    if (temp.left != null) {
                        queue.offer(temp.left);
                        deque.offer(temp.left.val);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                        deque.offer(temp.right.val);
                    }
                }

                if (deque.size() != 0) {
                    List<Integer> list = new ArrayList<>();

                    if (isPollFirst) {
                        while (!deque.isEmpty()) {
                            list.add(deque.pollFirst());
                        }
                    } else {
                        while (!deque.isEmpty()) {
                            list.add(deque.pollLast());
                        }
                    }

                    answer.add(list);
                }
                isPollFirst = !isPollFirst;
            }
        }

        return answer;
    }
}
