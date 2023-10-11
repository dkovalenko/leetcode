object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    val freq = collection.mutable.Map.empty[Int, Int]
    if (nums.size == 1) return nums(0)
    nums.foreach { num =>
      freq.get(num) match {
        case Some(n) => {
          freq.update(num, n+1)
          if (n + 1 > nums.size/2) {
            return num
          }
        }
        case None => {
          freq.put(num, 1)
        }
      }
    }
    0
  }
}