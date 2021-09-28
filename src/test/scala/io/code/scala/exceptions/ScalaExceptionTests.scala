package io.code.scala.exceptions

class TestScalaExceptions extends munit.FunSuite {
  test("Try, catch, finally execution.") {
    assertEquals(ExceptionFunctions.tryCatchFinally, ())
  }
  
  test("Try, finally execution.") {
    intercept[ArithmeticException] {
      ExceptionFunctions.tryFinally
    }
  }

  test("Try, catch execution.") {
    intercept[ClassCastException] {
      ExceptionFunctions.tryCatch
    }
  }

  test("Single try block execution.") {
    intercept[ExceptionFunctions.TryBlockOnlyIsCompilerWarningOnlyAndUseless] {
      ExceptionFunctions.justTry
    }
  }
}