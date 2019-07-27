package com.johnowl.services.locations

import java.math.BigDecimal
import java.math.MathContext
import java.text.DecimalFormat


fun main(args: Array<String>) {
    val num = 100.0 / 6378100.0
    println(num)

    val df = DecimalFormat("#.#")
    df.maximumFractionDigits = 8
    val n = df.format(num).replace(",", ".")
    println(n)



}

