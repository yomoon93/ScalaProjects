object Robot extends App{

  class Robot (val name:String = "Unknown"){


  def welcome(n:String) = s"Welcome $n! My name is $name"

    override def toString = s"Robot($name)"
  }
  class ItalianRobot(name:String) extends Robot(name){

  override def welcome(n: String) = s"Benvenuto $n! Il mio name e' $name"

}
  class EnglishRobot(name: String, country: String) extends Robot(name){
  override def welcome(n:String) = s"Welcome $n, I am $name from the country of $country!"
}
val robot = new Robot
val italian = new ItalianRobot("Marco")
val englishRobot = new EnglishRobot("Ron", "England")
  println(italian)
  println(englishRobot)
  println(robot)
  println(englishRobot.welcome("Kevin"))
  println(italian.welcome("Giancarlo"))
}