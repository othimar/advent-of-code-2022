fun main(){
    fun part1(input:List<String>):Int{
        val data = input.first()
        var id = 0
        for(i in 0 until  (data.length - 4)){
            val chunk = data.substring(i, i+4)

            if (chunk.length == chunk.toCharArray().distinct().joinToString("").length){
                id = i + 4
                break
            }
        }
        return id
    }

    fun part2(input:List<String>):Int{
        val data = input.first()
        var id = 0
        for(i in 0 until (data.length - 14)){
            val chunk = data.substring(i, i+14)

            if (chunk.length == chunk.toCharArray().distinct().joinToString("").length){
                id = i + 14
                break
            }
        }
        return id
    }

    check(part1(readInput("Day06_test")) == 10)
    check(part2(readInput("Day06_test")) == 29)


    val input = readInput("Day06")

    println(part1(input))
    println(part2(input))
}