package course2.week1.gen

/**
  * Created by Lech_Piechota on 2/13/2017.
  */
trait Generator[+T] {
  self =>
  def generate: T

  def map[S](f: T => S): Generator[S] = new Generator[S] {
    def generate = f(self.generate)
  }

  def flatMap[S](f: T=> Generator[S]): Generator[S] = new Generator[S] {
    def generate = f(self.generate).generate
  }
}
