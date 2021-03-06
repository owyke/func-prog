package objsets.intset

object IntSetsRun {

    def main(args: Array[String]) {
        val s1 = new NonEmpty(5, new Empty, new Empty)
        val s11 = s1 incl 1 
        val s111 = s11 incl 12
        val s1111 = s111 incl 2
        println(s1111)
        val s2 = new NonEmpty(8, new Empty, new Empty)
        val s3 = s1111 union s2 
        println(s3)
    }
}