package week4

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NatSuite extends FunSuite {

  test("zero and only zero is zero") {
    assert(Zero.isZero)
    assert(!new Succ(Zero).isZero)
  }

  test("predecessor of one is zero") {
    val one = new Succ(Zero)
    assert(one.predecessor === Zero)
  }

  test("predecessor of two is one") {
    val one = new Succ(Zero)
    val two = new Succ(one)
    assert(two.predecessor === one)
  }

  test("two plus three is five") {
    val two = new Succ(new Succ(Zero))
    val three = new Succ(two)
    assert(two + three == new Succ(new Succ(three)))
  }

  test("three minus two is one") {
    val two = new Succ(new Succ(Zero))
    val three = new Succ(two)
    assert(three - two == new Succ(Zero))
  }


}
