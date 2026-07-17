class MedianFinder {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // 先放入最大堆
        left.offer(num);
        // 把左边最大的数字移到右边
        right.offer(left.poll());
        // 保证左边的数量不小于右边
        if (right.size() > left.size()){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        // 数量相同，说明总数是偶数
        if (left.size() == right.size()){
            return ((double) left.peek() + right.peek())/2.0;
        } else {
            return left.peek();
        }
    }
}
