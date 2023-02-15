package org.fibonacci;

public class Fibonacci extends Thread{

  private final String number;

  public Fibonacci(String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;
  }

  @Override
  public void run() {
    int previouspreviousNumber = 0;
    int previousNumber = 0;
    int currentNumber = 1;

    for (int i = 1; i < Long.parseLong(number); i++) {
      previouspreviousNumber = previousNumber;
      previousNumber = currentNumber;
      currentNumber = previouspreviousNumber + previousNumber;
    }
    System.out.print("Fibonacci" + currentNumber);
  }

  public long calculate(String number) {
    int previouspreviousNumber=0;
    int previousNumber = 0;
    int currentNumber = 1;

    for (int i = 1; i < Long.parseLong(number); i++) {
      previouspreviousNumber = previousNumber;
      previousNumber = currentNumber;
      currentNumber = previouspreviousNumber + previousNumber;
    }
    return currentNumber;
  }

}
