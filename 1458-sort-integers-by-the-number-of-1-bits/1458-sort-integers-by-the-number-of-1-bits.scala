object Solution {
  def sortByBits(arr: Array[Int]): Array[Int] = {
    for (i <- 0 until arr.size) {
      arr(i) += Integer.bitCount(arr(i))*10001
    } 
    scala.util.Sorting.quickSort(arr)
    for (i <- 0 until arr.size) {
      arr(i) = (arr(i))%10001
    }
    arr
  }
}