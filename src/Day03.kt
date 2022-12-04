fun main(){
    fun part1(input:List<String>):Int{
        var priority = 0
        for(bag in input){
            val compSize = bag.length/2
            val firstComp = bag.filterIndexed { index, _ -> index < compSize }
            val secondComp = bag.filterIndexed { index, _ ->  index >= compSize}

            for (c in firstComp){
                if(secondComp.contains(c, false)) {
                    priority += if (c.toString() == c.lowercase()) {
                        c.code - 96
                    } else {
                        c.code - 64 +26
                    }
                    break
                }
            }
        }
        return priority
    }


    fun part2(input:List<String>):Int{

        var priority = 0
        val groups = input.windowed(3, 3)
        for(g in groups){
            val badge = g.first().first { g[1].contains(it) and g[2].contains(it) }
            priority += if (badge.toString() == badge.lowercase()) {
                badge.code - 96
            } else {
                badge.code - 64 +26
            }
        }
        return priority
    }


    check(part1(readInput("Day03_test")) == 157)
    check(part2(readInput("Day03_test")) == 70)

    val input = readInput("Day03")

    println(part1(input))
    println(part2(input))
}