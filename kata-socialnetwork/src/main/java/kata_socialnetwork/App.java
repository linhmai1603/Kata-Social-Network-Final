package kata_socialnetwork;

import java.io.InputStream;
import java.util.Scanner;

import kata_socialnetwork.domain.UserListImpl;
import kata_socialnetwork.parser.InputParser;

public class App {
	private final InputStream inputStream;
	private final InputParser inputParser;

	private Processor processor;

	public App(InputStream inputStream, InputParser inputParser) {
		this.inputStream = inputStream;
		this.inputParser = inputParser;
	}

	public void run() {
		Scanner scanner = new Scanner(inputStream);
		processor = new Processor(inputParser);

		while (scanner.hasNext()) {
			processor.process(scanner.nextLine());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App(System.in, new InputParser(new UserListImpl()));
		app.run();
	}
}
