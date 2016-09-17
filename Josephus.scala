package scala.josephus
object Josephus {

  def findLastSurvivor(count:Int, skip:Int ) = {
    // There are variety of way to generate sequence - this is CHIRADIP's fav
    val prisoners = Stream.from(0).takeWhile(_ < count).map(identity).toList

    // We dont change skip value here inside - one less thing to worry about
    implicit val _skip = skip

    //One-step-at-a-time isolate people in deathrow from potential surviors
    def isolate(deathrow: List[Int], potentialSurvivors: List[Int] )
                              (implicit countOff:Int): (List[Int], List[Int]) = {
      val stepOffset = if( potentialSurvivors.size < countOff )
                          countOff - potentialSurvivors.size else countOff

      // Slice and join is the key - Clojure style
      (deathrow ++ potentialSurvivors.take(stepOffset).drop(stepOffset-1),
      potentialSurvivors.drop(stepOffset) ++ potentialSurvivors.take(stepOffset-1))
    }
    //Look for the lone survivor while collecting people in deathrow in sequence
    def search_survivor(groups: (List[Int],List[Int])):
                                        (List[Int], List[Int]) = groups._2 match {
      case head :: Nil => (groups._1, List(head))
      case head :: tail => {
        search_survivor(isolate(groups._1,groups._2))
      }
    }

    search_survivor((List.empty[Int],prisoners))
  }

  val lonesurvivor = findLastSurvivor(32,4)._2.head

  final def main(args: Array[String]): Unit = {
    require(args.size == 2, "Usage: Josephus <numOfPrisoners> <killingEvery>")

    val numOfPrisoners = args(0).toInt
    val killingEvery = args(1).toInt

    println(findLastSurvivor(numOfPrisoners, killingEvery)._2.head)

  }
}
