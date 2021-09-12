package com.example.evapharma

import java.util.*

fun optimizeRank(inp: Vector<Vector<Int>>, out: Vector<Vector<Int>>, m: Int, n: Int){

    for ( i in 0..m){
        for (j in 0..n){


        for (k in 0..n){
        if ( inp[i][j] != inp[i][k] && inp[i][j] > inp[i][k] && out[i][j] <= out[i][k])
        {

            out[i][j]++


        }
        else  if ( inp[i][j] != inp[i][k] && inp[i][j] < inp[i][k] && out[i][j] >= out[i][k])
        {

            out[i][j]--


        }
    }
        for (k in 0..m){

        if ( inp[i][j] != inp[k][j] && inp[i][j] > inp[k][j] && out[i][j] <= out[k][j])
        {
            out[i][j]++

        }

        else  if ( inp[i][j] != inp[k][j] && inp[i][j] < inp[k][j] && out[i][j] >= out[k][j])
        {
            out[k][j]++

        }

    }
    }
    }
    for (i in 0..m){
        for (j in 0..n)
        print(out[i][j])
        println()
    }
}
fun getRankMatrix(inp: Vector<Vector<Int>>, out: Vector<Vector<Int>>, m: Int, n: Int) {
    var i:Int=0
    var j:Int=0
    while (i in 0 until m) {
        while (j in 0 until n) {
            var rank = 1
            var b=Vector<Int>()
            for (k in 0 until n) {

                if (b.indexOf(inp.get(i)?.get(k)) == -1 && (inp.get(i))?.get(j) !== inp.get(i)?.get(k) && inp.get(i)?.get(j)!! > inp.get(i)?.get(k)!!) {
                    rank++
                    b.addElement(inp.get(i)?.get(k))
                }
            }
            for (k in 0 until m) {
                if (b.indexOf(inp.get(k)?.get(j)) == -1 && (inp.get(i))?.get(j) !== inp.get(k)?.get(j) && inp.get(i)?.get(j)!! > inp.get(k)?.get(j)!!) {
                    rank++
                    b.addElement(inp.get(k)?.get(j))
                }

            }
            out[i][j]+=rank;
            j++
        }
        i++
    }
    optimizeRank(inp, out, m, n)

    for (i in 0 until m) {
        for (j in 0 until n) print(out.get(i).get(j))
        println()

    }
}
fun main(rgs:Array<String>){
    var input=Vector<Vector<Int>>()
    var out=  Vector<Vector<Int>>()
    val m=Scanner(System.`in`).nextInt()
    val n= Scanner(System.`in`).nextInt()
    for (i in 0 until m.toInt()) {
        var v= Vector<Int>()
        var g=Vector<Int>()
        for (j in 0 until n) {
            var x: Int
            x=Scanner(System.`in`).nextInt()
            v.addElement(x)
            g.addElement(0)
        }
        input.addElement(v)
        out.addElement(g)
    }
    getRankMatrix(input, out, m, n)

}
