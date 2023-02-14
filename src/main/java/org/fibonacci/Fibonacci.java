package org.fibonacci;

public class Fibonacci {

  public static int calculate(int number) {
    if (number == 0) {
      return 0;
    }
    if (number == 1) {
      return 1;
    }
    return calculate(number - 1) + calculate(number - 2);
  }

}
