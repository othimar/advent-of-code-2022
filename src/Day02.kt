fun main(){

    fun part1(input:List<String>):Int{
        var result = 0;
        for(round in input){
            result += when(round){
                "A X"-> 4
                "A Y"-> 8
                "A Z"-> 3

                "B X"-> 1
                "B Y"-> 5
                "B Z"-> 9

                "C X"-> 7
                "C Y"-> 2
                "C Z"-> 6

                else -> 0
            }
        }
        return result
    }

    fun part2(input:List<String>) :Int{
        var result = 0;
        for(round in input){
            result += when(round){
                "A X"-> 3
                "A Y"-> 4
                "A Z"-> 8

                "B X"-> 1
                "B Y"-> 5
                "B Z"-> 9

                "C X"-> 2
                "C Y"-> 6
                "C Z"-> 7

                else -> 0
            }
        }
        return result
    }

    check(part1(readInput("Day02_test")) == 15)
    check(part2(readInput("Day02_test")) == 12)

    val input = readInput("Day02")

    println(part1(input))
    println(part2(input))
}