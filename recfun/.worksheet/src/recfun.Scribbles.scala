package recfun

object Scribbles {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(44); val res$0 = 

	
	
	"a";System.out.println("""res0: String("a") = """ + $show(res$0));$skip(5); val res$1 = 
	'a';System.out.println("""res1: Char('a') = """ + $show(res$1));$skip(42); 
	
	
	
	
	
	var list = (1 until 10).toList;System.out.println("""list  : List[Int] = """ + $show(list ));$skip(41); 
  var list2 = list.filter(x => (x%2==0));System.out.println("""list2  : List[Int] = """ + $show(list2 ));$skip(25); val res$2 = 
  list2 ++ List(List(9));System.out.println("""res2: List[Any] = """ + $show(res$2))}
  
	
	
	
	
	
}
