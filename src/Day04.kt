fun main() {
    fun part1(input: List<String>): Int {
        var result = 0

        val regex = "(\\d+)-(\\d+),(\\d+)-(\\d+)".toRegex()


        for (line in input) {
            val matchesResult = regex.find(line)
            val (a, b, c, d) = matchesResult!!.destructured

            if (
                ((a.toInt() in c.toInt()..d.toInt()) and (b.toInt() in c.toInt()..d.toInt())) or
                ((c.toInt() in a.toInt()..b.toInt()) and (d.toInt() in a.toInt()..b.toInt()))
            ) {
                result++
            }
        }
        return result
    }


    fun part2(input: List<String>): Int {
        var result = 0

        val regex = "(\\d+)-(\\d+),(\\d+)-(\\d+)".toRegex()


        for (line in input) {
            val matchesResult = regex.find(line)
            val (a, b, c, d) = matchesResult!!.destructured

            if (
                ((a.toInt() in c.toInt()..d.toInt()) or (b.toInt() in c.toInt()..d.toInt())) or
                ((c.toInt() in a.toInt()..b.toInt()) or (d.toInt() in a.toInt()..b.toInt()))
            ) {
                result++
            }
        }
        return result
    }


    check(part1(readInput("Day04_test")) == 2)
    check(part2(readInput("Day04_test")) == 4)

    val input = readInput("Day04")

    println(part1(input))
    println(part2(input))
}