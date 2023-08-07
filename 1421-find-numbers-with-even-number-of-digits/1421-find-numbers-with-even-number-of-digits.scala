object Solution {
  def findNumbers(nums: Array[Int]): Int = {
    var result = 0
    nums.foreach { num => 
      var number = num
      var iterations = 0
      while (number >0) {
        number = number / 10
        iterations += 1
      }
      if (iterations % 2 == 0) {
        result += 1
      }
    }
    result
  }
}