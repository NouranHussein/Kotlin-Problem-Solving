package com.example.evapharma


import java.util.*


fun IsOperator(c: Char): Boolean {
    return c == '+' || c == '-' || c == '*' || c == '/' || c == '^'
}

fun IsOperand(c: Char): Boolean{
    if (c in 'A'..'Z') /* Define the character in between A to Z. If not, it returns False.*/ return true
    if (c in 'a'..'z') // Define the character in between a to z. If not, it returns False. */
        return true
    return if (c in '0'..'9') true else false
}
fun precedence(op: Char): Int {
    if (op == '+' || op == '-') /* it defines the lowest precedence */ return 1
    if (op == '*' || op == '/') return 2
    return if (op == '^') 3 else 0
}
fun eqlOrhigher(op1: Char, op2: Char): Boolean {
    val p1 = precedence(op1)
    val p2 = precedence(op2)
    if (p1 == p2) {
        return op1 != '^'
    }
    return p1 > p2
}
fun convert(x: String): String? {
    var infix = x
    val S=Stack<Char>()
    var postfix: String? = ""
    var ch: Char
    S.push('(')
    infix = "$x)"
    var i = 0
    while (i < infix.length) {
        ch = infix.get(i)
        if (ch == ' ') {
            i++
            continue
        } else if (ch == '(') {
            if (i + 1 < infix.length && infix.get(i + 1) === '-') {
                S.push('-')
                i++
            }
            S.push(ch)
        } else if (IsOperand(ch)) postfix += ch else if (IsOperator(ch)) {
            while (!S.empty() && eqlOrhigher(S.peek(), ch)) {
                postfix += S.peek()
                S.pop()
            }
            S.push(ch)
        } else if (ch == ')') {
            while (!S.empty() && S.peek() !== '(') {
                postfix += S.peek()
                S.pop()
            }
            S.pop()
        }
        i++
    }
    return postfix
}
fun main(rgs:Array<String>) {

   val input= readLine()
    val out: String? = convert(input.toString())
    val st= Stack<Int>()
    if (out != null) {
        for (i in 0 until out.length) {
            if (IsOperand(out.get(i))) {
                st.push(out.get(i) - '0')
            } else if (!st.empty()) {
                val op1: Int = st.peek()
                st.pop()
                if (!st.empty()) {
                    val op2: Int = st.peek()
                    st.pop()
                    if (out.get(i) == '+') st.push(op2 + op1)
                    if (out.get(i) == '-') st.push(op2 - op1)
                    if (out.get(i) == '*') st.push(op2 * op1)
                    if (out.get(i) == '/') st.push(op2 / op1)
                    if (out.get(i) == '^') st.push(op2 xor op1)
                } else if (out.get(i) == '-') {
                    val v = op1 * -1
                    st.push(v)
                }
            }
        }
    }
    println(st.peek())

}
