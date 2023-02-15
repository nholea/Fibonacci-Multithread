package org.fibonacci;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    Fibonacci fibonacci = new Fibonacci("3");
    OptionsMenu optionsMenu = new OptionsMenu();
    Program program = new Program(fibonacci,optionsMenu);
    program.start();
  }
}
