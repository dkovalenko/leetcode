import scala.collection.mutable.ArrayBuffer

object Solution {
  //[[1,5]], newInterval = [0,3]
  
  //[[1,2],[3,10],[12,16]], newInterval = [4,8]
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {

    implicit val ord: Ordering[Array[Int]] = Ordering.by(el => el(0))
    val sortedArray = ArrayBuffer(intervals:_*).addOne(newInterval).sorted
    val newArray = ArrayBuffer.empty[Array[Int]]
    
    
    for (i<-0 until sortedArray.size) {
      if (newArray.lastOption.isDefined && newArray.last(1) >= sortedArray(i)(0)) {
        newArray.last(1) = Math.max(sortedArray(i)(1),newArray.last(1)) 
      } else {
        newArray.addOne(Array(sortedArray(i)(0), sortedArray(i)(1)))
      }
    }
    
    newArray.toArray
  }
}