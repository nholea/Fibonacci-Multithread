package org.fibonacci;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    OptionsMenu optionsMenu = new OptionsMenu();
    Program program = new Program(optionsMenu);
    program.start();
  }
}
