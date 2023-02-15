package org.fibonacci;

public class Main {

  public static void main(String[] args) {
    Fibonacci fibonacci = new Fibonacci("3");
    OptionsMenu optionsMenu = new OptionsMenu();
    Program program = new Program(fibonacci,optionsMenu);
    program.run();
  }
}
