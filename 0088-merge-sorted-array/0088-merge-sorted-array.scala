object Solution {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    if (nums1.isEmpty || nums2.isEmpty) return ()
    
    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //nums1 = [2,0], m = 1, nums2 = [1], n = 1
    var insertIdx = Math.max(nums1.size - 1, 0)
    var num1Idx = Math.max(m - 1, 0) //0
    var num2Idx = Math.max(n - 1, 0) //0
    
    while (insertIdx >= 0) {
      if (num1Idx >= 0 && num2Idx >=0) {
        if (nums1(num1Idx) >= nums2(num2Idx)) {
          checkAndTakeSide()
        } else {
          takeRight()
        }
      } else {
        if (num1Idx >= 0) {
          checkAndTakeSide()
        } else {
          takeRight()
        }
      }
      insertIdx -= 1
    }

    def checkAndTakeSide() = {
      if (nums1(insertIdx) == 0 && m == 0) {
        takeRight()
      } else {
        takeLeft()
      }
      
    }

    def takeLeft() = {
      nums1(insertIdx) = nums1(num1Idx)
      num1Idx -= 1
    }

    def takeRight() = {
      nums1(insertIdx) = nums2(num2Idx)
      num2Idx -= 1
    }
  }

}