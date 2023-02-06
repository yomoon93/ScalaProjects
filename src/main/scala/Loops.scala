object Loops extends App {
  //  var sum:Int = 0
  //  var number = 0

  //  while(number <= 20){
  //   sum = number*(number+1)/2
  //    number+=1
  //    println(sum)
  //  }
  def sumTo(n: Int): Int = {
    var sum = 0
    for (n <- 1 to 20) {

      sum += n

    }
    sum
  }


}
