object Solution {
    def search(nums: Array[Int], target: Int): Int = {
        var left = 0
        var right = nums.size - 1
        var pivot = 0
        while (left <= right) {
            pivot = left + (right-left)/2
            if (target==nums(pivot)) return pivot
            if (target < nums(pivot)) {
                right = pivot -1
            } else {
                left = pivot + 1
            }
        }
        return -1
    }
}