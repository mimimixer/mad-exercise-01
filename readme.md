# MAD - Exercise 01
## Tasks
* Watch the Kotlin Crash-course Video in Moodle or complete the tutorials 
* **[Introduction to programming in Kotlin]
* (https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1)
* ** and **[Kotlin fundamentals]
* (https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1)**.
* Answer the questions inside this Readme.md file and push it to your repository.
* Submit your coding solution of the Number Guessing Game inside the repository.
* Submit the link to your repository in Moodle.

## Questions
### Describe how Kotlin handles null safety. What are nullable types and non-null types in Kotlin? 
### (0,5 points)

<span style="color:blue">Provide your answer here! </span>
> Note: you can also use code snippets to illustrate your answer. 

As Kotlin includes per default the null-safety feature, so usually I cannot use NULL-values, this is 
called that the values are non-nullable. The idea is to avoid the possibility of 
null-pointer-exceptions during runtime by catching them during coding (IDE) or compilation 
(runtime exception is when I want to use functions on non initialized objects or objects that 
contain null-values). Still kotlin is so flexible, that it allows for explicitly make a value 
nullable, if you want to show that a value does not exist (yet). 

```kotlin 
// declaration
val a: String = "value" // non-null type: cannot EVER be null
val b: String? = null // with ? I can create a variable of non-null or null type, so that it also can 
                      // be or become null
// In case I want to use a variable that can have the value NULL inside a function, I must use the ?
// again, so the program will stop the execution of the function in case the variable is null:
println(b?.uppercase())

// I also can use the non-assertion call with !!, so that the execution of the function is forced 
// even if the variable is null. Therefore, I must be sure it is NOT NULL, else the program crashes:
println(b!!.uppercase())

// I also could just put the function inside an if-condition:
if(b != null) {
    println(b.uppercase())
}
```

### What are lambda expressions and higher order functions in Kotlin? Why would you store a function 
### inside a variable? (0,5 points)

<span style="color:blue">Provide your answer here!</span>
In Kotlin, functions are considered first-class constructs, this means functions can be treated as
datatype: functions can be stored in variables, can be passed as arguments, or be returned from 
other functions. Storing functions in variable makes the code more concise, flexible, and reusable.

Functions that take functions as parameters, or return a function are called higher order functions. 
They usually are using lambda expressions, anonymous functions or named functions. Even listeners, 

Lambda expressions are variables of a special kind of datatype. They are called function literals -
in comparison to literal values, like 10 Value of an Int type, or "hello" value of a String type,
{ println("I'm a Lambda expression") } is a value of a function type - this means 
they are functions that are not declared but passed immediately as an expression. Lambda expressions
can therefore be also anonymous functions.

You also can name = assign a lambda expression to a variable:
val lambdaExpressionName = {println("I'm a Lambda expression")}
here there are no input parameters, and there also is no return value, that makes it so simple. If
there were input parameters and a return value, you would have to declare them too, inserting
: (InputParameterDatatype) -> ReturnValueDatatype between the name and the = sign. The last 
value/expression before the closing curly bracket } is considered to be the return value. 
So, to be really correct, we will add the data types to our simple code too: 
val lambdaExpressionName: () -> Unit = {println("I'm a Lambda expression")}
But the Parameter declarations are optional for inferred data types, so you could leave out empty 
parameters and their datatype, or also inferred data types, like val sum = {x: Int, y: Int -> x + y}
BUt you also could declare them: val sum: (Int, Int) -> Int =  {x, y -> x + y } actually it seems
like you can do it in a lot of ways, but some are more readable. 

### Provide a solution for the following number guessing game inside `App.kt`. (3 points)

## Number Guessing Game in Kotlin
The game is a simple number guessing game. The task is to generate a random, max 9-digit, number. 
The number must **not contain repeating digits**. Valid digits are 1-9.
Ask the user to guess the max 9-digit number. The game is finished when the user guesses the 
correct digits in the correct order.
In each round, the user gets feedback about the number of correct digits and the number of correct 
digits in the correct position.
The output should be in the format "n:m", where "n" is the number of digits guessed correctly 
regardless of their position, and "m" is the number of digits guessed correctly at their correct 
position. Here are some examples:

This example shows the game flow with 4-digits to guess (the default argument)

Generated number: 8576
-	User input: 1234, Output: 0:0
-	User input: 5678, Output: 4:1
-	User input: 5555, Output: 1:1
-	User input: 3586, Output: 3:2
-	User input: 8576, Output: 4:4 -> user wins

Take a look into the provided code structure in `src/main/kotlin/App.kt`. Implement the following 
methods (lambda expressions):
- _playNumberGame(digitsToGuess: Int = 4)_ (1 point): The main game loop that handles user input 
    and game state. Make use of _generateRandomNonRepeatingNumber_ and 
   _checkUserInputAgainstGeneratedNumber_ here. This function also utilizes a default argument 
- _generateRandomNonRepeatingNumber_ (1 point): A lambda expression that generates a random number 
   with non-repeating digits of a specified length.
- _checkUserInputAgainstGeneratedNumber_ (1 point): A lambda expression that compares the user's 
   input against the generated number and provides feedback.

``CompareResult.kt`` This class is a data structure which helps with bundling the result of the 
comparison of the user input and the generated number. Look at the toSting() and use it in your 
output.

Run the project with `./gradlew run` and test your implementation with the provided tests 
in `src/test/kotlin/AppTest.kt` with `./gradlew test`.

# Project Structure
The project is structured into two main Kotlin files:

**App.kt**: Contains the main game logic and functions.

**AppTest.kt**: Contains unit tests for the various functions in App.kt.

