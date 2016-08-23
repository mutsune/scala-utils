package com.mutsune.util.string

/**
  * Created by nakayama.
  */
object PrettyString {

    final def upperFirstLowerRest(str: String) = str.headOption match {
        case Some(x) => x.toUpper + str.drop(1).toLowerCase
        case _ => ""
    }

}
