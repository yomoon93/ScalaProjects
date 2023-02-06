  trait Animal{
   def sleep = "ZzZzz"
   def eat(food:String):String
    def move(x:Int, y:Int):String
  }
   class Dog extends Animal(){
     override def eat(food: String): String = {
       s"I only eat $food that smells good or till i throw up!"
     }
     override def move(x: Int, y: Int): String = {
       s"I moved this many $x spaces up and this many $y down"
     }

   }
  object Animal extends App{
  val agDog = new Dog()
    println(agDog.sleep)
    println(agDog.eat("meat"))
    println(agDog.move(4,6))

}
