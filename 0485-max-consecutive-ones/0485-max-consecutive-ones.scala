object Solution {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    var totalMax = 0
    var currentMax = 0
    nums.foreach { num =>
      if (num == 1) {
        currentMax += 1
      } else {
        if (currentMax > totalMax) {
          totalMax = currentMax
        }
        currentMax = 0
      }
    }

    Math.max(totalMax, currentMax)
  }
}