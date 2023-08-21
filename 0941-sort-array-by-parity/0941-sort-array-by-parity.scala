object Solution {
  def sortArrayByParity(nums: Array[Int]): Array[Int] = {
    if (nums.size == 1) return nums
    //nums = [3,1,2,4]
    //nums = [2,4,3,1]
    var p1 = 0
    var p2 = nums.size - 1
    while (p1 < p2) {
      if (isEven(nums(p1))) {
        p1 +=1
      } else {
        if (isEven(nums(p2))) {
          var tmp = nums(p2)
          nums(p2) = nums(p1)
          nums(p1) = tmp
        } else {
          p2 -= 1
        }
      }
    }
    nums
  }
  def isEven(number: Int) = number % 2 == 0
  def isOdd(number: Int) = !isEven(number)
}