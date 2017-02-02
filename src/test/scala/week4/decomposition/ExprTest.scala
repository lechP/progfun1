package week4.decomposition

import org.scalatest.FunSuite

/**
  * Created by Lech_Piechota on 2/1/2017.
  */
class ExprTest extends FunSuite {

  test("1 + 2 should evaluate to 3") {
    assert(Sum(Number(1), Number(2)).eval === 3)
  }

  test("1 + 2 should be showed as '1 + 2'") {
    val expected = "1 + 2"
    assert(Sum(Number(1), Number(2)).show === expected)
  }

}
