class NumArray {

    int[] data;
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        data = nums;
        n = nums.length;
        tree = new int[n * 4];
        // build Tree
        buildSegTree(0, n - 1, 0);
    }

    private void buildSegTree(int l, int r, int i) {
        // base case
        if (l == r) {
            tree[i] = data[l];
            return;
        }
        // recursively build the tree
        int mid = (l + r) / 2;
        int left_idx = 2 * i + 1;
        int right_idx = 2 * i + 2;
        buildSegTree(l, mid, left_idx);
        buildSegTree(mid + 1, r, right_idx);
        tree[i] = tree[left_idx] + tree[right_idx];
    }

    private void updateRange(int idx, int val, int l, int r, int i) {
        if (l == r) {
            tree[i] = val;
            return;
        }
        int mid = (l + r) / 2;
        int left_idx = 2 * i + 1;
        int right_idx = 2 * i + 2;
        if (idx <= mid) {
            updateRange(idx, val, l, mid, left_idx);
        } else {
            updateRange(idx, val, mid + 1, r, right_idx);
        }
        tree[i] = tree[left_idx] + tree[right_idx];

    }

    public void update(int index, int val) {
        updateRange(index,val,0,n-1,0);
    }

    public int sumRange(int left, int right) {
        return getSum(left, right, 0,0, n - 1);
    }

    private int getSum(int start, int end, int i, int l, int r) {
        // Case 1: If the range [start, end] is completely outside the range [l, r]
        // represented by this node
        if (end < l || start > r) {
            return 0; // No overlap, so return 0
        }

        // Case 2: If the range [start, end] completely covers the range [l, r]
        // represented by this node
        if (start <= l && end >= r) {
            return tree[i]; // Complete overlap, so return the stored sum for this segment
        }

        // Case 3: Partial overlap: recursively query the left and right subtrees
        int mid = (l + r) / 2;
        int left_idx = 2 * i + 1;
        int right_idx = 2 * i + 2;

        // Query the left and right subtrees for the sum
        int leftSum = getSum(start, end, left_idx, l, mid);
        int rightSum = getSum(start, end, right_idx, mid + 1, r);

        // Return the sum of both subtrees
        return leftSum + rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */