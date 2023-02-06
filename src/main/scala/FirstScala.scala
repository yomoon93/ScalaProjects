import java.util.Date

object FirstScala {
  def main(args:Array[String]){
//    println("Hello from scala")
  }
  val a = "Why you mad"
  val b = "because i'm learning"

  // for interpolation and for separating words
  val str1 = "1\t2\t3"
  val str2 = s"${a +" "+b}"
//    println(str1)
//    println(str2)

  // replacing words in the scala
  val order2 = "A glass of beer - i like beer"
//  println(order2.replaceAll("[Bb]eer", "coke"))
//  println(order2.replaceFirst("[Bb]eer", "coke"))

// for matching words in a sentence
  val order = "A glass of beer"
  //println(order.matches(".* beer"))

  //Capturing groups - it's a little unorthodox
  val order3 = "A glass of beer"
  val order4 = "A bottle of wine"

  // Capture groups
  val drink = raw".* (glass|bottle) of (beer|wine|coke).*".r
  val drink (yourAmount, yourDrink) = order

  def abs(i: Int) = if(i>=0) i else -i
//  abs(-1)
  //abs(2)

  // if statements
  val x = 11
  //if(x % 2 == 0) println("Even")else println("odd")

  //while loops
  //var is something else you can use besides val both different
  // val is used because you can't mutate it, var you can mutable
  var j = 1
//  while(j <= 5){
//    if(j%2 == 0)
//      println(j+ ":even")
//    else
//      println(j+ ":odd")
//      j +=1
//
//  }
// different ways of typing this
  var k = 1
  var tot = 0
  while (k <= 5){
    tot += k
    k += 1
  }

//  println(tot)

  // loops and how to do them in scala
//  for(a <- 1 to 5) println(a)

  //another way to loop
//  1 to 5 foreach(print(_) )





//  println(drink)
//  println(yourDrink)
//  println(yourAmount)
  class MyClass(name:String){
  def sayHello(otherName:String) = s"Hi $otherName, my name is $name!"
}

object myObject {
  val a = new MyClass("Scala")
  println(a.sayHello("Martin"))
}

//  println(myObject.a)

//  try{
//      throw new IllegalStateException("Error!")
//    }catch{
//    case ex:RuntimeException => println("Something went wrong")
//  }

  def divideByTwo(n:Int): Int = n/2
  def addOne(f: Int => Int): Int => Int = f andThen(_ + 1)


  class Person2( val first:String, val last:String, val age:Int ){
  def isAdult (adultThreshold:Int):Boolean = age >= adultThreshold

  }
  val p = new Person2("John", "Doe", 25)
//  println(p.first)
//  println(p.age)
//  println(p.isAdult(24))

  class Person3(f:String, l:String, val age:Int = 18){
    override def toString = s"$f $l ($age)"
  }
  val kev = new Person3("Kevin", "Munar")
//  println(kev)
//  println("The person is " + kev)

  class MyClass24{
    val now = new Date().toString
    lazy val now2 = new Date().toString
    //With def, the expression is evaluated on each reference to the property
    def now3 = new Date().toString
  }
  val t1 = new MyClass24
  val t2 = new MyClass24

//  println(t1.now)
//  println(t2.now2)

  class Complex (val re:Int = 0, val im:Int = 0){
    def+(that:Complex)=new Complex(this.re+that.re, this.im+that.im)
    def-(that:Complex)=new Complex(this.re - that.re, this.im-that.re)

    override def toString: String = s"${re} + ${im}i"
  }

  val c1 = new Complex(1,2)
  object MySingleton{
    val myField = 100
    def sayHello = println("Hello")
  }
  MySingleton.sayHello
//  println(MySingleton.myField)

//Companion Object and Factory
  class Person(val first:String, val last:String,age:Int = 21)
  object Person{
    def apply(f:String, l:String) = new Person(f,l)
  }
  val peep = Person("John", "Doe")
//  println(peep)
//
//  println(peep.first)

  object HelloWorld {
    def main(args:Array [String]): Unit ={
//      println("Hello from scala")
    }
  }

  //Case Classes
  //Compiler generates implementations of certain important overriding methods
  //-equals
  // -hashcode
  //-toString
  // class parameters promoted to immutable fields
  // Compiler generates copy method
  val in2 = Cash(99,22)
  val c2 = in2.copy()

  println(in2.equals(c2))

//  println(in2)
  // named parameter passing
  val c3 = in2.copy(pence=50)
  println(c3)
  case class Cash(pounds:Int, pence:Int)

  val in = Cash(100,0)
  val out = Cash(150,0)


  //Disadvantage of Case Classes
  /*
  * Additional bytecode generated - for compiler generated methods
  * Inheritance is restricted
  * -case class cannot inherit from another case class
  *
  * */

  //Packages
  /*
  * Scala uses package to organize namespace
  * -package can be nested
  * - Scala uses packages to organise namespace, like java. However packages are more powerful and acts as
  * first class  citizens in the language, allowing true nesting as shown in the example
  * */
  /*
  package myPackage{
    class AA
    package mySubPackage{
      class AB1
      class AB2
    }
  }
  class C
  object foo extends App{
    val a = new myPackage.AA
    val b = new myPackage.mySubPackage.AB1
    val c = new C
  }
  */

  //Package objects
  /*
  * Container for definitions global to package
  * -not just type definitions
  * Scala allows a package to contain members other than just definitions.
  * A package object is an object specific to a package that contains data, methods and
  * other components that are essentially global to the package, and exist once for the package
  * package object myPackage{
  * val packageGlobalVal = 100;
  * def packageGlobalDef = "Hello There"
  * }
  *
  * object MyProg extends App{
  * val myVal = myPackage.packageGlobaalVal
  * println(myPackage.packageGlobalDef)
  * }

  * Use like other package members
  *
  * */

  // Importing
  /*
  * import myPackage....
  * object foo extends App{
  * val a = new AA
  * val b = new B.AB1
  * def foo = {
  *   import myPackage.mySubPackage.AB2
  *   val ab2 = new AB2
  *   }
  * }
  *
  * */

  //Default imports
  /*
  * java.lang  //package
  *scala._     // package object
  * scala.Predef._ //object
  *
  *
  *
  * */


}
