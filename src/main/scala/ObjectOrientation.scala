object ObjectOrientation extends App {
  //java eequivalent:public static void main(String[] args)
  class Animal{
    def eat() = println("I'm eating")
    val age: Int = 0
  }

  val anAnimal = new Animal
  class Dog( val name: String) extends Animal// constructor definition

  val aDog = new Dog("Lassie")

  // constructor arguments are not fields: need to put val before the constructor argument

  println(aDog.name)

  //subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat()

  // abstract class
  abstract class WalkingAnimal{
    val hasLegs = true // by default public
    def walk(): Unit
  }
  //interface  ultimate abstract type
  trait Carnivore{
    def eat (animal:Animal): Unit
  }

  trait Philosopher {
    def ?!(thought:String):Unit //valid method name
  }


  class Crocodile extends Animal with Carnivore{
    override def eat(animal: Animal): Unit = println("I am eating you animal!")

    def ?!(thought:String):Unit = println("I was thinking: $thought")
  }
  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so i can eat pretty much anything")
  }

  //singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 5327
    def apply(x:Int): Int = x + 1
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65)

  object Animal{// companion - companion object
    // companions can access each other's private fields/methods
    // singleton Animal and instance of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods
  /*
  case classes = lightweight data structures with some boilerplate
  -sensible equals and hash code
  -serialization
  -companion with apply
  -pattern matching
*/
  case class Person(name: String, age:Int)
// may be constructed without new
  val bob = Person("Bob", 54) // Person.apply("Bob",54)

  //exceptions
  try {
    // code that can throw
    val x:String = null
    x.length
  }catch {
    case e: Exception => "some faulty error message"
  }finally {
    //execute some code no matter what
  }

  // generics
  abstract class MyList[T]{
    def head: T
    def tail: MyList[T]
  }
  //using a generic with a concrete type
  val aList:List[Int] = List(1,2,3)
  val first = aList.head // int
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head //string

  //Point #1: in Scala we usually operate with Immutable values/obo an object must return Another object
  //Any modification to an object must return Another object
  /*
  * Benefits:1) works miracles in multithreaded/distributed env
  *           2) helps making sense of the code ("reasoning about")
  *
  * */
  val reversedLst = aList.reverse//

  //Point #2: Scala is closest to the 00 ideal
}




