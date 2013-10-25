object ListRunner {

    def flatten(xs: List[Any]): List[Any] = {
        if (xs.isEmpty) List()
        else {
            println(xs.head)
            xs.head match {

                case e: List[Any] => flatten(e) ++ flatten(xs.tail)
                case x: Int => xs.head :: flatten(xs.tail)
            }
        }
    }

    def main(args: Array[String]): Unit = {
        println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
    }

}