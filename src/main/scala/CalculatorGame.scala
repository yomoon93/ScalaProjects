class Player(val name: String, val age: Int) {
// must makes it so
  override def toString = s"Player($name, $age)"
}

class HighScore(val scoreName: Player, val score: Int){

  override def toString = s"HighScore($scoreName, $score)"
}

object CalculatorGame extends App {
  val r = scala.util.Random
  var line:String = ""
  var age: Int = 0
  var kPlayer = new Player("",0)
  var akHighScore = new HighScore(createPlayer(),addQuiz(5))
  var answer: Int = 0
  var userAnswer: Int = 0
  var correct: Boolean = true
  var score: Int = 0

  def createPlayer(): Player ={
    val scanner = new java.util.Scanner(System.in)
      println("What is your name?")
       line = scanner.nextLine()
     println("What is your age?")
       age = scanner.nextInt()
     kPlayer = new Player(line, age)
     kPlayer
  }


  def addQuestion(a:Int, b:Int): Boolean = {
    val scanner = new java.util.Scanner(System.in)
    println(s"What is $a + $b " )
    userAnswer = scanner.nextInt()
    answer = a + b
    if (answer == userAnswer) {
      println("You are correct")
      correct = true
      score+=1
    }
     else
      println("You are wrong")
      correct = false
      correct
  }

  def addQuiz(length: Int):Int  ={
    val scanner = new java.util.Scanner(System.in)
    println("Would you like a)addition or b)division")
    var answer = scanner.nextLine()
    if(answer.equals("a"))
    for(a <- 1 to length ){
      addQuestion(r.nextInt(10),r.nextInt(10))
    }
    else
      for(a <- 1 to length ){
        moduloQuestion(r.nextInt(10),r.nextInt(10))
      }
    score
  }

  def moduloQuestion(a:Int, b:Int): Boolean={
    val scanner = new java.util.Scanner(System.in)
    println(s"What is $a / $b ")
    userAnswer = scanner.nextInt()
    answer = a / b
    if (answer == userAnswer) {
      println("You are correct")
      correct = true
      score += 1
    }
    else
      println("You are wrong")
    correct = false
    correct
  }
//  println(akHighScore.scoreName + " the score: " + akHighScore.score)

  println(akHighScore.scoreName + " the score: " + akHighScore.score)

//  createPlayer()
//  addQuestion(2,2)

//  val akHighScore = new HighScore(kPlayer,score)
//  addQuiz(5)
//  println(akHighScore.scoreName + " the score: " + akHighScore.score )
//  println(r.nextInt(20))

//  val aPlayer = new Player("Kevin", 29)
//  val aHighscore = new HighScore(aPlayer, 400)
//  addQuiz(5)
//  println("Player: " + kPlayer.name + " has an age " + kPlayer.age)
//  println("Player: " + aHighscore.scoreName + " has a score of " + aHighscore.score)
//  println("Player: " + kPlayer.name + " has an age " + kPlayer.age)
}
