
fun main(){
    fun part1(input: List<String>): String {
        val data = ArrayList<ArrayDeque<String>>()

        val regex = "\\d+".toRegex()
        for (line in input) {
            val regResult = regex.findAll(line)
            if (regResult.any()) {
                val numberOfLines = input.indexOf(line)
                val matchResults = regex.findAll(line)
                val stackPositions = ArrayList<Int>()
                matchResults.iterator().forEachRemaining {
                    val position = it.range.first
                    stackPositions.add(position)
                }

                for (i in 0 until stackPositions.size) {
                    data.add(ArrayDeque())
                }

                for ((stackId, stack) in data.withIndex()) {

                    val positionOfChar = stackPositions[stackId]
                    for (i in 0 until numberOfLines) {
                        val char = input[i].getOrNull(positionOfChar)

                        if (char != null) {
                            if (char.toString().isNotBlank()) stack.addFirst(char.toString())

                        }
                    }

                }
                break
            }
        }

        val moves = ArrayList<Array<Int>>()
        for (line in input) {
            if (Regex("move").containsMatchIn(line)) {
                val res = Regex("\\d+").findAll(line, 0)
                val quantity = res.iterator().next().value.toInt()
                val from = res.iterator().next().next()!!.value.toInt()
                val to = res.iterator().next().next()!!.next()!!.value.toInt()

                moves.add(arrayOf(quantity, from, to))
            }
        }

        for (move in moves) {
            val quantity = move[0]
            val from = move[1] - 1
            val to = move[2] - 1
            for (i in 1..quantity) {
                data[to].addLast(data[from].last())
                data[from].removeLast()
            }
        }

        return data.joinToString("") { it.last() }
    }

    fun part2(input: List<String>): String {

        val data = ArrayList<ArrayDeque<String>>()

        val regex = "\\d+".toRegex()
        for (line in input) {
            val regResult = regex.findAll(line)
            if (regResult.any()) {
                val numberOfLines = input.indexOf(line)
                val matchResults = regex.findAll(line)
                val stackPositions = ArrayList<Int>()
                matchResults.iterator().forEachRemaining {
                    val position = it.range.first
                    stackPositions.add(position)
                }

                for (i in 0 until stackPositions.size) {
                    data.add(ArrayDeque())
                }

                for ((stackId, stack) in data.withIndex()) {

                    val positionOfChar = stackPositions[stackId]
                    for (i in 0 until numberOfLines) {
                        val char = input[i].getOrNull(positionOfChar)

                        if (char != null) {
                            if (char.toString().isNotBlank()) stack.addFirst(char.toString())

                        }
                    }

                }
                break
            }
        }

        val moves = ArrayList<Array<Int>>()
        for (line in input) {
            if (Regex("move").containsMatchIn(line)) {
                val res = Regex("\\d+").findAll(line, 0)
                val quantity = res.iterator().next().value.toInt()
                val from = res.iterator().next().next()!!.value.toInt()
                val to = res.iterator().next().next()!!.next()!!.value.toInt()

                moves.add(arrayOf(quantity, from, to))
            }
        }

        for (move in moves) {
            val quantity = move[0]
            val from = move[1] - 1
            val to = move[2] - 1

            val toMove = ArrayList<String>()
            for (i in 1..quantity) {
                toMove.add(data[from].last())
                data[from].removeLast()
            }
            for (i in quantity - 1 downTo 0) {
                data[to].addLast(toMove[i])
            }
        }

        return data.joinToString("") { it.last() }
    }
    check(part1(readInput("Day05_test")) == "CMZ")
    check(part2(readInput("Day05_test")) == "MCD")

    val input = readInput("Day05")

    println(part1(input))
    println(part2(input))
}