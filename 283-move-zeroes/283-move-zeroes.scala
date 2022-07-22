object Solution {
    def moveZeroes(nums: Array[Int]): Unit = {
        if (nums.size <= 1) return ()
        val newArr = new Array[Int](nums.size+1)
        var zeroCount = 0
        var idx = 0
        nums.foreach { num =>
            if (num != 0) {
              newArr(idx) = num
              idx += 1
            } else {
                zeroCount += 1
            }
        }
        for (i <- 0 to zeroCount) {
          newArr(idx) = 0
          idx += 1
        }
        for (i <-0 until nums.size) {
            nums(i) = newArr(i)
        }
    }
}