object Solution {
  def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
    //nums = [1,0,1,1,0,0,1], max = 4, currmax = 2, cons = 1
    //nums = [0,0,1,1,0]
    //nums = [0,0,0,0,1]
    //1. pretend that 0 is 1, check next if zero - reset, if 1 - sum to max
    //2. count consecutive real 1's
    var max = 0
    var cons = 0
    var currentMax = 0
    var zeroUsed = false
    for (i <- 0 until nums.size) {
      if (nums(i) == 1) {
        cons += 1
        currentMax += 1
      } else {
        if (!zeroUsed) {
          currentMax += 1
          zeroUsed = true
        } else {
          currentMax = cons + 1
        }
        cons = 0
      }
      max = Math.max(currentMax, max)
    }

    max
  }
}