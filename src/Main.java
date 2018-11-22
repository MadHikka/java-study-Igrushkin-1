import java.util.*;

public class Main {
	
	public static void method(String text, ArrayList<String> WordsArgs) {
		Date time = new Date();
		long ttime = time.getTime();
		System.out.println(ttime);

		String words[] = text.split(" ");
		int argIter = 0;

		while (argIter < WordsArgs.size()) {

			int wordsIter = 0;
			int quant = 0;

			while (wordsIter < words.length) {
				if (words[wordsIter].equals(WordsArgs.get(argIter)))
					quant++;
				wordsIter++;
			}
			System.out.println((argIter + 1) + "." + WordsArgs.get(argIter) + ":" + quant);
			argIter++;
		}
		System.out.println(time.getTime());
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		ArrayList <String> WordsArgs = new ArrayList<String>();

		System.out.println("Input text");

		String text = scan.nextLine();

		do {
			System.out.print("Input argument:");

			String arg = scan.nextLine();

			if (arg.equals(" "))
				break;

			WordsArgs.add(arg);

		} while (!false);

		method(text, WordsArgs);
		scan.close();
	}

}
