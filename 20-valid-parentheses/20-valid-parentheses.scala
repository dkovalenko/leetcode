import scala.collection.mutable.Stack
import scala.util.Try

object Solution {
  //Stack. (, )
  val mapping = Map[Char, Char](
    '(' -> ')',
    ')' -> '(',
    '{' -> '}',
    '}' -> '{',
    '[' -> ']',
    ']' -> '[',
  )
  val opening = Set('[', '{', '(')
  
  def isValid(s: String): Boolean = {
    val stack = Stack.empty[Char]
    s.foreach { char =>
      //println(stack)
      val prevOpt = Try(stack.pop).toOption
      prevOpt match {
        case Some(prev) => if (opening.contains(char)) {
          stack.push(prev)
          stack.push(char)
        } else {
          if (prev != mapping(char))
            return false
        }
        case None => if (opening.contains(char)) {
          stack.push(char)
        } else {
          return false
        }
      }
    }
    stack.isEmpty
  }
}