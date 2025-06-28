class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    public MedianFinder() {
        left= new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (right.isEmpty() && left.isEmpty())
            left.offer(num);
        else if (right.isEmpty())
            if (left.peek() > num)
                left.offer(num);
            else
                right.offer(num);
        else if (right.peek() > num)
            left.offer(num);
        else
            right.offer(num);
        if (right.size() == left.size() + 2)
            left.offer(right.poll());
        if (right.size() + 2 == left.size())
            right.offer(left.poll());
    }
    
    public double findMedian() {
        if(left.size()==right.size()) return ((double)(right.peek()+left.peek()))/2;
        return right.size()>left.size()?(double)right.peek():(double) left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */