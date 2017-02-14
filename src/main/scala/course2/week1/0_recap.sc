val f: String => String = { case "ping" => "pong"}


f("ping")
// f("abc") <- error! (not defined for "abc")

val g: PartialFunction[String, String] = {case "ping" => "pong"}
g.isDefinedAt("ping")
g.isDefinedAt("abc")



