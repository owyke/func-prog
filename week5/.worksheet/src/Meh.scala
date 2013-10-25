object Meh {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(56); 
  println("Welcome to the Scala worksheet");$skip(191); 
  
  def flatten(xs: List[Any]): List[Any] = {
		if(xs.isEmpty) List()
		else xs.head match {
			case e: List[Any] => flatten(e) ++ flatten(xs.tail)
			case y :: ys => y ::flatten(ys)
		}
	};System.out.println("""flatten: (xs: List[Any])List[Any]""")}
	}
