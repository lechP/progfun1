package week4.decomposition

/**
  * Created by Lech_Piechota on 2/2/2017.
  */
object Evaluator {
  def eval(e: Expr) : Int = e match {
    case Number(n) => n
    case Sum(e1, e2) => eval(e1) + eval(e2)
  }
}
