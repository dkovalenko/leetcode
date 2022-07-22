object Solution {
    def sortedSquares(nums: Array[Int]): Array[Int] = {
        var left = 0
        var right = nums.length - 1
        var result = scala.collection.mutable.ArrayBuffer.empty[Int]

        while (left <= right) {
            val leftNum = nums(left)
            val leftSqr = leftNum * leftNum
            val rightNum = nums(right)
            val rightSqr = rightNum * rightNum
            if (leftSqr > rightSqr) {
                result.prepend(leftSqr)
                left += 1
            } else {
                result.prepend(rightSqr)
                right -= 1
            }
        }
        result.toArray
    }
}