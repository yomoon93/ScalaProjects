object AgeChecker extends App{

  val scanner = new java.util.Scanner(System.in)

  var lineString = ""

  while(!(lineString == "exit")){
    println("How old are you user!")
    var line = scanner.nextInt()
    if (line >= 18)
      println("You are old enough")
    else if (line == 17)
      println("You must be " + 1 + " year older to enter")
    else
      println("You must be " + (18 - line) + " years older to enter")
  }

}
