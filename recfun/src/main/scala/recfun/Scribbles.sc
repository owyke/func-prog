package recfun

object Scribbles {

	
	
	"a"                                       //> res0: String("a") = a
	'a'                                       //> res1: Char('a') = a
	
	
	
	
	
	var list = (1 until 10).toList            //> list  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  var list2 = list.filter(x => (x%2==0))          //> list2  : List[Int] = List(2, 4, 6, 8)
  list2 ++ List(List(9))                          //> res2: List[Any] = List(2, 4, 6, 8, List(9))
  
	
	
	
	
	
}