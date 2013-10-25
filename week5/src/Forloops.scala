object Forloops {


    
    def scalarProduct(xs: List[Double], ys: List[Double]) : Double = {
            (for( (x,y) <- (xs zip ys)) yield x*y).sum
        
    }


    def main(args: Array[String]): Unit = {
        val xs = List[Double](7,2,3)
        val ys = List[Double](2,3,4)
        
        
//        println(scalarProduct(xs,ys))
        
        println(    for (b <- books; a <- b.authors if a startsWith "Bird") 
                        yield b.title)
                        
                        
                        
                        
        println(books flatMap(b => for( a <- b.authors if a startsWith "Bird") 
                        yield b.title));  
                        
        println(books flatMap(b =>  b.authors withFilter (a => a startsWith "Bird") map (_ => b.title)))   
                        
                        
                        
                        
        println(for (b <- books; a <- b.authors withFilter (q => q startsWith "Bird")) 
                        yield b.title)
        
        println(books flatMap(b => for( a <- b.authors withFilter (a => a startsWith "Bird")) 
                        yield b.title))
                        
    }
    
    def isSafe(col: Int, queens: List[Int]): Boolean = {
       val row = queens.length;
       val queensWithRows = (row -1 to 0 by -1) zip queens
       queensWithRows forall {
           case (r, c) => col != c && math.abs(col-c) != row -r
       }
       
       
    }
    
   
    case class Book(title: String, authors: String*)
    
    
    val books: List[Book] =
        List(
                Book("Struct 123", "Abelson, Harold", "BirdSussman, Gerald J."),
                Book("Struct 456", "Bebelson, Harold", "Sussman, Gerald J."),
                Book("Struct 456", "Bebelson, Harold", "Sussman, Gerald J."),
                Book("Surre 789", "BirdCebelson, Harold", "Sussman, Gerald J.")
        )
                
    
    


}