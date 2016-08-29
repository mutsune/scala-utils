package com.mutsune.util.string

/**
  * Created by nakayama.
  */
object StringBuilderUtil {

    def padToRight(sb: StringBuilder, len: Int, elem: Char) = {
        var diff: Int = len - sb.length
        while (diff > 0) {
            sb += elem
            diff -= 1
        }
        sb
    }

}
