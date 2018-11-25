import java.util.*;

public class Main {
	//имена любых переменных должны всегда быть с маленькой буквы (кроме констант), речь про WordsArgs
	public static void method(String text, ArrayList<String> WordsArgs, boolean reg) {//плохое имя для метода "method", надо переименовать
		Date time = new Date();
		long ttime = time.getTime();
		System.out.println(ttime); //для чего эта переменная? если это просто для отладки, то надо убрать

		String words[] = text.split(" ");
		int argIter = 0;

		while (argIter < WordsArgs.size()) {

			int wordsIter = 0;
			int quant = 0;

			while (wordsIter < words.length) { // подумай как переделать данный цикл на for без использования переменной wordsIter
				if (reg) {
					if (words[wordsIter].equals(WordsArgs.get(argIter)))
						quant++;
				} else {
					if (words[wordsIter].equalsIgnoreCase(WordsArgs.get(argIter)))
						quant++;
				}

				wordsIter++;
			}
			System.out.println((argIter + 1) + "." + WordsArgs.get(argIter) + ":" + quant); // желательно вывести пояснение что такой-то аргумент встречается столько то раз
			argIter++;
		}
		
		System.out.println(time.getTime()); //если это для отладки, то надо убрать
	}
	
	public static void method(String text, ArrayList<String> WordsArgs) {// этот метод не используется?
		method(text,WordsArgs,true);
	}

	/**
	 * данная реализация не умеет искать слова, если они со знаками препинания
	 * подумай как можно модифицировать, чтобы можно было распарсить вот такой текст:
	 * Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
	 * с параметром amet или elit
	 */
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> WordsArgs = new ArrayList<>();// если используется Java 8 версии и выше, то не нужно указывать тип коллекции
		System.out.println("Enable case-sensitive?(1 - yes, 0 - no)");
		boolean reg = scan.nextBoolean(); //почему boolean, если на предыдущем шаге ожидаем 1 или 0 ?

		scan.nextLine(); // без ручного перевода строки не работает, проверь еще раз

		System.out.println("Input text:");

		String text = scan.nextLine();// нужно добавить пояснение, что окончанием считывания параметров является знак пробела

		do {
			System.out.print("Input argument:");

			String arg = scan.nextLine();

			if (arg.equals(" "))
				break;

			WordsArgs.add(arg);

		} while (!false);// зачем !false если можно просто true ?
		method(text, WordsArgs, reg);
		scan.close();
	}

}
