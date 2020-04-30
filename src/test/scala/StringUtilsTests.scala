import com.theevilroot.epam.lab7.StringUtils
import org.scalatest.flatspec.AnyFlatSpec

class StringUtilsTests extends AnyFlatSpec{

  // Scala functions test

  "toLower" should "return lowercase char even when lowercase char is passed" in {
    assert('a'.toLower == 'a')
  }

  it should "return lowercase char  when uppercase char is passed" in {
    assert('A'.toLower == 'a')
  }

  "toUpper" should "return uppercase char even when uppercase char is passed" in {
    assert('A'.toUpper == 'A')
  }

  it should "return uppercase char even when lowercase char is passed" in {
    assert('a'.toUpper == 'A')
  }

  // handle test

  "case_encrypt" should "return empty string when empty string passed" in {
    assert(StringUtils.case_encrypt("") == "")
  }

  it should "return full lowercase string when passed string with characters from first half of alphabet" in {
    val string = "AbBcDeEEEdHEEiI"
    assert(StringUtils.case_encrypt(string) == string.toLowerCase())
  }

  it should "return full uppercase string when passed string with characters from second half of alphabet" in {
    val string = "zZyyQqQQwoopw"
    assert(StringUtils.case_encrypt(string) == string.toUpperCase())
  }

  it should "replace all lowercase m to uppercase M" in {
    val string = "mmm"
    val expected = string.replace("m", "M")
    assert(StringUtils.case_encrypt(string) == expected)
  }

  it should "lowercase all characters from first half of alphabet and uppercase - all from second half of alphabet" in {
    val string = "abcdefghijklmnopqrstuvwxyz";
    val expected = "abcdefghijklMNOPQRSTUVWXYZ";
    assert(StringUtils.case_encrypt(string) == expected)
  }

}
