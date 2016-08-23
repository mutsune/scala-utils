package com.mutsune.util.math

/**
  * Created by nakayama.
  */
object Measure {

    def rate(numerator: Int, denominator: Int): BigDecimal =
        (BigDecimal(numerator) / BigDecimal(denominator)) * 100 setScale(2, BigDecimal.RoundingMode.HALF_UP)

}
