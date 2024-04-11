# Learning Kotlin

## Basics

* String interpolation "$variable"
* declare functions with `fun`
* declare functions at the top level of the file
  * ?? What is their namespace? how to import them?
* `Array<String>` same as array in Java
* if is an expression (meaning you can return stuff)

```kotlin
package into

fun main() {
    println("Hello!")
}
```

## Variables

* `val` declares a read-only variable
* `var` declares a mutable variable
* statically type language
* Good practices
  * prefer vals to vars
  * dont omit types in declarations 

## Functions

* `fun <functionName>(<functionArgs>): <ReturnType { <body> }`
* 