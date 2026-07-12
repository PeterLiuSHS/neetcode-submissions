class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new LinkedList<>();
        }
        // 先构造一个用于返回的结果
        List<List<Integer>> result = new LinkedList<>();
        // 再构造一个queue用来放节点
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) { // 这里是用来限制弹出的次数，本轮弹出次数最大不得超过上一轮塞进去的次数

            List<Integer> level = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            result.add(level);
        }
        return result;
    }
}
