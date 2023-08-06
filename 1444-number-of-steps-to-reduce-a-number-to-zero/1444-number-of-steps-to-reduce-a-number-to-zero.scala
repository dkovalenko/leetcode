object Solution {
    def numberOfSteps(num: Int): Int = {
        var result = 0
        var currentNum = num
        while (currentNum > 0) {
            if (currentNum % 2 == 1) {
                currentNum -= 1
            } else {
                currentNum = currentNum / 2
            }
            result += 1
        }
        result
    }
}