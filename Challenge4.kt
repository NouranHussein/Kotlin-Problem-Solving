package com.example.evapharma

import java.lang.Math.abs
import java.util.*


fun getHealth(room: Vector<Vector<Int>?>, m: Int, n: Int): Int {
    var current_node: Int? = room.get(0)?.get(0)
    var i = 0
    var j = 0
    var res: Int? = room.get(0)?.get(0)
    while (true) {
        if (i + 1 >= m && j + 1 >= n) break
        if (i + 1 < m && j + 1 < n && room.get(i + 1)?.get(j)!! >= room.get(i)?.get(j + 1)!!) {
            current_node = room.get(i + 1)!!.get(j)
            i++
        } else if (i + 1 < m && j + 1 < n && room.get(i + 1)?.get(j)!! < room.get(i)?.get(j + 1)!!) {
            current_node = room.get(i)?.get(j + 1)
            j++
        } else if (j + 1 >= n) {
            current_node = room.get(i + 1)?.get(j)
            i++
        } else if (i + 1 >= m) {
            current_node = room.get(i)?.get(j + 1)
            j++
        }
        res = res?.plus(current_node!!)
    }
    if(res==null)return 0
    return res
}

fun main(rgs:Array<String>) {
    var room= Vector<Vector<Int>?>()
    val m: Int=Scanner(System.`in`).nextInt()
    val n: Int=Scanner(System.`in`).nextInt()
    var x: Int

    for (i in 0 until m) {
        var rows= Vector<Int>()
        for (j in 0 until n) {
           x= Scanner(System.`in`).nextInt()
            rows.addElement(x)
        }
        room.addElement(rows)
    }
println( abs(getHealth(room, m, n)) + 1)

}
