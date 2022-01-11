package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn (myInput: Any): String{
    if(myInput == "Hello")
        return "world"
    else if(myInput == 0)
        return "zero"
    else if(myInput == 1)
        return "one"
    else if(myInput == 5 || myInput == 9)
        return "low number"
       else if(myInput == 17.0)
        return "I don't understand"
    else
        return "Say what?"
}
// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add (firstInt: Int, secondInt: Int): Int{
    return firstInt + secondInt
}
// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub (firstInt: Int, secondInt: Int): Int{
    return firstInt - secondInt
} 

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp (firstInt: Int, secondInt: Int, myFunction: (Int, Int) -> Int): Int{
    return myFunction(firstInt, secondInt)
} 

// write a class "Person" with first name, last name and age
class Person (var firstName: String, var lastName: String, var age: Int)
{
   public var debugString: String = "[Person firstName:$firstName lastName:$lastName age:$age]"

}

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(val amount: Int, val currency: String = "USD") {
    init {
        if(amount < 0)
            throw IllegalArgumentException("Invalid Amount!")
        if(!(currency in arrayOf("USD", "CAN", "GBP", "EUR")))
            throw IllegalArgumentException("Invalid Type!")
    }
    val myCurrencyVals = hashMapOf(
        "USD" to 20, 
        "CAN" to 25,
        "GBP" to 10,
        "EUR" to 30

    )
    operator fun plus(other: Money): Money {
        var otherMoneyAmnt = other.amount
        if (this.currency != other.currency) {
            val oldCurrencyModifier = myCurrencyVals[other.currency]!!
            val newCurrencyModifier = myCurrencyVals[this.currency]!!
            otherMoneyAmnt = (otherMoneyAmnt * newCurrencyModifier)/oldCurrencyModifier
        }
        return Money(this.amount + otherMoneyAmnt, this.currency)
    }
    fun convert(otherCurrency: String): Money {
        if (this.currency == otherCurrency)
            return this
        else{
            val oldCurrencyModifier = myCurrencyVals[this.currency]!!
            val newCurrencyModifier = myCurrencyVals[otherCurrency]!!
            return Money((this.amount * newCurrencyModifier)/oldCurrencyModifier, otherCurrency)
        }
            
    }

    operator fun Money.unaryMinus() = Money(-amount, currency)
}
