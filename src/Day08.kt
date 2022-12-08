fun main() {
    fun part1(input: List<String>): Int {
        var number = 0;
        for (i in 1 until input.size - 1) {
            val line = input[i]
            for (j in 1 until line.length - 1) {
                val tree = line[j].toString().toInt()
                var visibleTop = true
                var visibleBottom = true
                var visibleLeft = true
                var visibleRight = true
                for (k in input.indices) {
                    if (k < i) {
                        if (input[k][j].toString().toInt() >= tree) {
                            visibleLeft = false
                        }
                    }


                    if (k > i) {
                        if (input[k][j].toString().toInt() >= tree) {
                            visibleRight = false
                            break
                        }
                    }
                }
                for (k in line.indices) {
                    if (k < j) {
                        if (input[i][k].toString().toInt() >= tree) {
                            //println("neighbour top "+input[i][k].toString().toInt())
                            visibleTop = false
                        }
                    }
                    if (k > j) {
                        if (input[i][k].toString().toInt() >= tree) {
                            visibleBottom = false
                            break
                        }
                    }
                }
                if (visibleLeft or visibleRight or visibleTop or visibleBottom) {
                    number++
                }
            }
        }
        number += input.size * 2 + input[0].length * 2 - 4
        return number
    }

    fun part2(input: List<String>): Int {
        val scenicScore = ArrayList<Int>()
        for (i in 1 until input.size - 1) {
            val line = input[i]
            for (j in 1 until line.length - 1) {
                val tree = line[j].toString().toInt()
                println("Tree $tree")
                var sCTop = 0
                var sCBottom = 0
                var sCLeft = 0
                var sCRight = 0
                for (k in i - 1 downTo 0) {

                    if (input[k][j].toString().toInt() < tree) {
                        sCTop++
                    } else {
                        sCTop++
                        break
                    }
                }

                for (k in i + 1 until input.size) {

                    if (input[k][j].toString().toInt() < tree) {
                        sCBottom++
                    } else {
                        sCBottom++
                        break
                    }
                }

                for (k in j - 1 downTo 0) {

                    if (input[i][k].toString().toInt() < tree) {
                        sCLeft++
                    } else {
                        sCLeft++

                        break
                    }

                }

                for (k in j + 1 until line.length) {

                    if (input[i][k].toString().toInt() < tree) {
                        sCRight++
                    } else {
                        sCRight++

                        break
                    }


                }
                println()

                scenicScore.add(sCLeft * sCRight * sCTop * sCBottom)
            }
        }
        return scenicScore.max()
    }

    check(part1(readInput("Day08_test")) == 21)
    check(part2(readInput("Day08_test")) == 8)
    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}