object Solution {
  
  def rob(nums: Array[Int]): Int = {
    val dp = new Array[Int](nums.size+1)
    val N = nums.size
    if (N == 0) return 0
    dp(N) = 0
    dp(N-1) = nums(N-1)
    for (i <- N-2 to 0 by -1) {
      dp(i) = Math.max(dp(i+1), dp(i+2) + nums(i))
    }
    dp(0)
  }
}