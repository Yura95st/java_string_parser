package java_string_parser;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main
{

	public static void main(String[] args)
	{
		IWordProcessor wordProcessor = new WordProcessor();

		wordProcessor.setWordLength(30);

		wordProcessor.setDelimiters(new ArrayList<Character>()
				{
			{
				this.add(';');
				this.add('#');
				this.add(' ');
				this.add(',');
				this.add('.');
				this.add('/');
				this.add('@');
			}
				});

		try
		{
			Path path = Paths.get(args[0]);

			List<String> lines = Files.readAllLines(path,
					StandardCharsets.UTF_8);

			wordProcessor.setSource(lines);
			wordProcessor.processWords();

			List<String> words = wordProcessor.getWordsWithMaxLength();

			System.out
			.println("Here are the list of the words with max length:");

			for (String word : words)
			{
				System.out.println(word);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
