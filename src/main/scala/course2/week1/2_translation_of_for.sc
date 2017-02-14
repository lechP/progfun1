case class Book(title: String, authors: List[String])

val books: Set[Book] = Set(
  Book(title = "Structure and Interpretation of Computer Programs",
    authors = List("Abelson, Harald", "Sussman, Gerald J.")),
  Book(title = "Introduction to Functional Programming",
    authors = List("Bird, Richard", "Walder, Phil")),
  Book(title = "Effective Java",
    authors = List("Bloch, Joshua")),
  Book(title = "Effective Java 2",
    authors = List("Bloch, Joshua")),
  Book(title = "Java Puzzlers",
    authors = List("Bloch, Joshua", "Gafter, Neal")),
  Book(title = "Programming in Scala",
    authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill"))
)


for (b <- books; a <- b.authors if a startsWith "Bird") yield b.title


books flatMap (
  b => b.authors.withFilter(a => a startsWith "Bird") map (a => a + "aaa"))

books flatMap (
  b => b.authors.withFilter(a => a startsWith "Bird") map (_ => b.title))


