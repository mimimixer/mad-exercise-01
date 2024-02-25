/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package at.ac.fhcampuswien

import java.lang.NumberFormatException

class App {
    // Game logic for a number guessing game
    fun playNumberGame(digitsToGuess: Int = 4) {
        //TODO: build a menu which calls the functions and works with the return values
        val numberToGuess = generateRandomNonRepeatingNumber(digitsToGuess)
        var notGuessed = true
        //println("we were tying to guess this number: $numberToGuess")
        while (notGuessed){
            print(" please enter a number with $digitsToGuess distinct digits: ")
            try {
                val input = readln().toInt()
                val output = checkUserInputAgainstGeneratedNumber(input, numberToGuess).toString()
                print(output)
                if (output.last().digitToInt() == digitsToGuess){
                    println(" Congratulations! You guessed the number $numberToGuess right! YAY!")
                    notGuessed = false
                }
            }catch (iae: IllegalArgumentException) {
                println("input must be a number with $digitsToGuess distinct digits. try again")
            }
        }

        //println(checkUserInputAgainstGeneratedNumber(1234, numberToGuess))
    }

    /**
     * Generates a non-repeating number of a specified length between 1-9.
     *
     * Note: The function is designed to generate a number where each digit is unique and does not
     * repeat. It is important to ensure that the length parameter does not exceed the maximum
     * possible length for non-repeating digits (which is 9 excluding 0 for base-10 numbers).
     *
     * @param length The length of the non-repeating number to be generated.
     *               This dictates how many digits the generated number will have.
     * @return An integer of generated non-repeating number.
     *         The generated number will have a number of digits equal to the specified length and
     *         will contain unique, non-repeating digits.
     * @throws IllegalArgumentException if the length is more than 9 or less than 1.
     */
    val generateRandomNonRepeatingNumber: (Int) -> Int = { length ->
        //TODO implement the function
        if (length in 1..9) {
            (1..9).shuffled().take(length).joinToString("").toInt()
        }else {
            println("be reasonable! your number must have min 1 and max 9 digits")
            throw IllegalArgumentException("not creating numbers with less than 1 or more than 9 digits")
        }
    }

    /**
     * Compares the user's input integer against a generated number for a guessing game.
     * This function evaluates how many digits the user guessed correctly and how many of those
     * are in the correct position. The game generates number with non-repeating digits.
     *
     * Note: The input and the generated number must both be numbers.
     * If the inputs do not meet these criteria, an IllegalArgumentException is thrown.
     *
     * @param input The user's input integer. It should be a number with non-repeating digits.
     * @param generatedNumber The generated number with non-repeating digits to compare against.
     * @return [CompareResult] with two properties:
     *         1. `m`: The number of digits guessed correctly (regardless of their position).
     *         2. `n`: The number of digits guessed correctly and in the correct position.
     *         The result is formatted as "Output: m:n", where "m" and "n" represent the above
     *         values, respectively.
     * @throws IllegalArgumentException if the inputs do not have the same number of digits.
     */
    val checkUserInputAgainstGeneratedNumber: (Int, Int) -> CompareResult = { input, generatedNumber ->
        //TODO implement the function
        var m = 0
        var n = 0
        val generatedNumberList = generatedNumber.toString().map { it.toString().toInt() }
        val inputNumberList = input.toString().map { it.toString().toInt() }
        if (generatedNumberList.size !=inputNumberList.size) {
            throw IllegalArgumentException("size of input number does not match number to guess")
        }

        if (inputNumberList.size != inputNumberList.distinct().size){
            throw IllegalArgumentException("whoopsie, digits are not distinct")
        }

        generatedNumberList.forEach{ digit ->
            if (digit in inputNumberList) {
                m++
                if (generatedNumberList.indexOf(digit) == inputNumberList.indexOf(digit)){
                    n++
                }
            }
        }
        CompareResult(m, n)   // return value is a placeholder
    }
}

fun main() {
    println("Hello Player, we are paying a number guessing game!")
    val play = App()
    var wannaPlay = true
    while(wannaPlay) {
        print("how long will be the number you want to guess? ")
        val digitsToGuess = readln().toInt()
        play.playNumberGame(digitsToGuess)
        print("do you want to play again? for yes type 1 ")
        try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            wannaPlay = false
            println("\n\nwe had a lot of fun! good bye!")
        }
    }

    println()
}
