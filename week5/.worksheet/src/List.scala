object List {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(181); 
  
  def flatten(xs: List[Any]): List[Any] = {
	if(xs.isEmpty) List
	else xs.head match {
		case e:List[Any] => flatten(e)++flatten xs.tail
		case y::ys => y++ flatten xs.tail
	}
};System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(50); val res$0 = 
flatten(List(List(1, 1), 2, List(3, List(5, 8))));System.out.println("""res0: <error> = """ + $show(res$0))}
}
