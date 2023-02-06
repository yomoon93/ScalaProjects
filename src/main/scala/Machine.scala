
  class VendingMachine {
    var chocolateBar = 0
    var granolaBar = 0
    var totalMoney = 0.0

    // we buy the product depending if the product is Available
    def buy(product: String, money: Double): String =
      if (!isProductAvailable(product))
        s"Sorry, product $product not available"
      else if (!isMoneyEnough(product, money))
        s"Please, insert more money"
      else
        completeRequest(product, money)

    //the cost is set here and if the money greater than the cost we will be able to buy the product
    def isMoneyEnough(product: String, money: Double): Boolean = {
      val cost = if (product == "chocolate") 1.5
      else 1
      money >= cost
    }
    // this is connected to the first buy method
    def isProductAvailable(product: String): Boolean = {
      val productQuantity = {
        if (product == "chocolate") chocolateBar
        else if (product == "granola") granolaBar
        else 0
      }
      productQuantity > 0
    }
    //What should happen if you complete a buy hence the collectMoney and the releaseProduct and the message
    def completeRequest(product: String, money: Double): String = {
      collectMoney(money)
      releaseProduct(product)
      s"There you go! Have a $product bar"
    }

// adds the money to the totalMoney
    def collectMoney(money: Double) =
      totalMoney += money
// we remove one from the total granola or chocolate
    def releaseProduct(product: String) =
      if(product == "chocolate") chocolateBar -= 1
      else if(product == "granola") granolaBar -=1

}
  // we create a instance of the machine
  object VendingMachine extends App{
    val aMachine = new VendingMachine()
    aMachine.chocolateBar += 2
    aMachine.granolaBar += 3

    println(aMachine.buy("chocolate", 1))
    println(aMachine.buy("granola", 1))
    println(aMachine.buy("granola", 1))
    println(aMachine.buy("granola", 1))
    print(aMachine.totalMoney)
  }
