package string

import com.mutsune.util.string.StringBuilderUtil
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by nakayama.
  */
class StringBuilderUtilTest extends FlatSpec with Matchers {

    "StringBuilder" should "be modified" in {
        val sb0 = new StringBuilder
        StringBuilderUtil.padToRight(sb0, 3, ' ')
        sb0.result shouldBe "   "

        val sb1 = new StringBuilder
        sb1.append("foo")
        StringBuilderUtil.padToRight(sb1, 5, ' ')
        sb1.result shouldBe "foo  "

        val sb2 = new StringBuilder
        StringBuilderUtil.padToRight(sb2, -4, ' ')
        sb2.result shouldBe ""
    }

}
