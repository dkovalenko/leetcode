/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */
//1 2 3 4 5 6 7

//1 2 3 4 5
class Solution extends VersionControl {
    def firstBadVersion(n: Int): Int = {
        var done = false
        var left = 1
        var right = n
        
        var minBad: Int = 1
        while (!done) {
            var pivot =  left + ((right - left) /2)
            val pivotBad = isBadVersion(pivot)
            //println(s"pivot = $pivot, bad = $pivotBad")
            if (pivotBad) {
                minBad = pivot
                if (left == pivot || right-left == 0) {
                    done = true
                }
                right = pivot - 1
            } else {
                left = pivot + 1
            }
        }
        
        minBad
    }
}