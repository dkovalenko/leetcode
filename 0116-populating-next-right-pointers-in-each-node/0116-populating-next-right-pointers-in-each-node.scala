/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var left: Node = null
 *   var right: Node = null
 *   var next: Node = null
 * }
 */
import scala.collection.mutable.ListBuffer
import scala.collection._

object Solution {
    
    def connect(root: Node): Node = {
        // val lm = mutable.Map.empty[Int, ListBuffer[Node]]
        // if (root != null ) {
        //     traverse(root, 1, lm)
        //     lm.foreach {
        //         case (level, elements) => {
        //             println(level, elements.map(_.value))
        //             setNext(elements.toList)
        //         }

        //     }
        // }

        if (root == null) {
            return root;
        }
        val q = new collection.mutable.Queue[Node]
        q.enqueue(root)

        while (q.nonEmpty) {
          val size = q.size
          //println("size="+size)
          for (i <- 0 until size) {
            val current = q.dequeue
            //println("current="+current.value)
            if (i < size -1) {
              current.next = q.front
            }
            if (current.left != null) {
              //println("current.left="+current.left.value)
              q.enqueue(current.left)
            }
            if (current.right != null) {
              //println("current.right="+current.right.value)
              q.enqueue(current.right)
            }
          }
        }
        root
    }
    
    def traverse(current: Node, level: Int, lm: mutable.Map[Int, ListBuffer[Node]]): Unit = {
        val left = current.left
        val right = current.right
        
        if (left != null) {
            lm.get(level) match {
                case None => {
                    //println(level, left.value, right.value)
                    lm.update(level, ListBuffer(left, right))
                }
                case Some(lb) => {
                    //println(level, left.value, right.value)
                    lm.update(level, lb.addAll(List(left, right)))
                }
            }
            traverse(left, level + 1, lm)
            traverse(right, level + 1, lm)
        }
    }
    
    def setNext(list: List[Node]): Unit = {
        list match {
            case head :: tail => {
                head.next = tail.headOption.getOrElse(null)
                setNext(tail)
            }
            case _ => ()
        }
    }
    
    
}