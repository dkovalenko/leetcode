object Solution {
    // 1 3 5 6
    def searchInsert(nums: Array[Int], target: Int): Int = {
        var left = 0
        var right = nums.size -1
        var pivot = 0
        while (left <= right) {
            pivot = left + (right - left)/2
            val current = nums(pivot)
            if (target == current) return pivot
            if (target < current) right = pivot - 1
            if (target > current) left = pivot + 1
        }
        
        left
    }
}