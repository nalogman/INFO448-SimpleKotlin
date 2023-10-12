package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(input: Any) {
    when(term) {
        7||11 -> return("win")
        2||3||12 -> return ("loss")
        in 4..6||8..10 -> return("number")
        is Int -> return("Input a number 1-12")
        is String -> return("Input a number 1-12")
    }
    return("Don't gamble kids")
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(a: Int, b: Int): Int {
    return(a + b)
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(a: Int, b: Int): Int {
    return(a - b)
}

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return(op(a, b))
}
// write a class "Person" with first name, last name and age
class Person(val firstName: String, val lastName: String, val age: Int)

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator
class Money(private var _amount: Int, private val _currency: String) {
    init {
        require(_amount >= 0) { "Amount can't be negative" }
        require(_currency in setOf("USD", "EUR", "CAN", "GBP")) { "Invalid currency" }
    }

    val amount: Int
        get() = _amount

    val currency: String
        get() = _currency

    fun convert(targetCurrency: String): Money {
        val conversionRate = when (_currency) {
            "USD" -> when (targetCurrency) {
                "GBP" -> _amount / 2
                "EUR" -> _amount * 3 / 2
                "CAN" -> _amount * 5 / 4
                else -> _amount
            }

            "GBP" -> when (targetCurrency) {
                "USD" -> _amount * 2
                "EUR" -> _amount * 3
                "CAN" -> _amount * 5 / 2
                else -> _amount
            }

            "EUR" -> when (targetCurrency) {
                "USD" -> _amount * 2 / 3
                "GBP" -> _amount / 3
                "CAN" -> _amount * 5 / 6
                else -> _amount
            }

            "CAN" -> when (targetCurrency) {
                "USD" -> _amount * 4 / 5
                "GBP" -> _amount * 2 / 5
                "EUR" -> _amount * 6 / 5
                else -> _amount
            }

            else -> _amount
        }
        return Money(conversionRate, targetCurrency)
    }

    operator fun plus(other: Money): Money {
        var changeMoney = other.convert(this.currency)
        return (Money(changeMoney.amount + this.amount, this.currency))
    }
}