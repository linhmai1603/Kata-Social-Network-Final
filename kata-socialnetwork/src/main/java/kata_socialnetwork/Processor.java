package kata_socialnetwork;

import kata_socialnetwork.command.Command;
import kata_socialnetwork.parser.InputParser;

public class Processor {
  private final InputParser inputParser;

  public Processor(InputParser parser) {
    this.inputParser = parser;
  }

  public void process(String input) {
    Command command = inputParser.parse(input);
    command.execute();
  }
}
