package io.code.scala.exceptions

object ExceptionFunctions {

  def tryCatchFinally: Unit = {
    try
      Array[Int]().apply(0)
    catch {
      case idxex: IndexOutOfBoundsException => println(s"${tryCatchFinallyStr}Crisis averted. Note that curly braces are necessary for the catch block.")
    }
    finally
      println(s"Exception handled, and then, the 'finally' block is executed.$o")
  }

  def tryFinally: Unit = {
    try 
      3 / 0
    finally
      println(s"${tryFinallyStr}Exception still thrown; it was important to run this line of code.$o")
  }

  def tryCatch: Unit = {
    try 
      Array[Int]().asInstanceOf[List[Double]]
    catch {
      case e: Exception => 
        println(s"${tryCatchStr}Caught and rethrown.$o")
        throw e
      case c: ClassCastException =>
        println("This line will never be executed because 'e' above is a more general exception.")
    }
  }

  def justTry: Unit = {
    try {
      println(justTryStr)
      throw new TryBlockOnlyIsCompilerWarningOnlyAndUseless
    }
  }

  class TryBlockOnlyIsCompilerWarningOnlyAndUseless extends Exception

  val bw = Console.BOLD + Console.WHITE + Console.BLUE_B
  val o  = Console.RESET

  val tryCatchFinallyStr = s"""
  def tryCatchFinally: Unit = {
    try
      Array[Int]().apply(0)
    catch {
      case idxex: IndexOutOfBoundsException => println("Crisis averted. Note that curly braces are necessary for the catch block.")
    }
    finally
      println("Exception handled, and then, the 'finally' block is executed.")
  }
  
$bw"""

  val tryFinallyStr = s"""
  def tryFinally: Unit = {
    try 
      3 / 0
    finally
      println("Exception still thrown; it was important to run this line of code.")
  }
  
$bw"""

  val tryCatchStr = s"""
  def tryCatch: Unit = {
    try 
      Array[Int]().asInstanceOf[List[Double]]
    catch {
      case e: Exception => 
        println("Caught and rethrown.")
        throw e
      case c: ClassCastException =>
        println("This line will never be executed because 'e' above is a more general exception.")
    }
  }
  
$bw"""

  val justTryStr = """
  def justTry: Unit = {
    try {
      throw new TryBlockOnlyIsCompilerWarningOnlyAndUseless
    }
  }
  
"""
}

