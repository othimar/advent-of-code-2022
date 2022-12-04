fun main() {
    fun part1(input: List<String>): Int {
        val data: ArrayList<ArrayList<Int>> = ArrayList()
        data.add(ArrayList())
        for (str in input) {
            if (str.isBlank()) {
                data.add(ArrayList())
            } else {
                data.last().add(str.toInt())
            }
        }
        return data.map { it.sum() }.max()

    }

    fun part2(input: List<String>): Int {
        val data: ArrayList<ArrayList<Int>> = ArrayList()
        data.add(ArrayList())
        for (str in input) {
            if (str.isBlank()) {
                data.add(ArrayList())
            } else {
                data.last().add(str.toInt())
            }
        }

        val dataSum = data.map { it.sum() }
        return with(dataSum.sorted()) {
            val first = this.last()
            val second = this[dataSum.size - 2]
            val third = this[dataSum.size - 3]

            first + second + third
        }

    }
    check(part1(readInput("Day01_test")) == 24000)
    check(part2(readInput("Day01_test")) == 45000)


    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
