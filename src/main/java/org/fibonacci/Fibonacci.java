package org.fibonacci;

public class Fibonacci extends Thread{

  private final String number;

  private Long currentNumber = 1L;

  public Fibonacci(String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;
  }


  public Long getFibonacci() {
    return currentNumber;
  }

  @Override
  public void run() {
    try {
      Long previouspreviousNumber;
      Long previousNumber = 0L;

      for (int i = 1; i < Long.parseLong(number); i++) {
        previouspreviousNumber = previousNumber;
        previousNumber = currentNumber;
        currentNumber = previouspreviousNumber + previousNumber;
      }
      Thread.sleep(10000);

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
