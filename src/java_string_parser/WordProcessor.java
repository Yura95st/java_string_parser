package java_string_parser;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor implements IWordProcessor
{
	private List<Character> delimiters;

	private List<String> source;

	private int wordLength;

	private List<String> words;

	public WordProcessor()
	{
		this.delimiters = new ArrayList<Character>();
		this.source = new ArrayList<String>();
		this.words = new ArrayList<String>();
		this.wordLength = 1;
	}

	@Override
	public List<Character> getDelimiters()
	{
		return this.delimiters;
	}

	@Override
	public List<String> getSource()
	{
		return this.source;
	}

	@Override
	public int getWordLength()
	{
		return this.wordLength;
	}

	@Override
	public List<String> getWords()
	{
		return this.words;
	}

	@Override
	public List<String> getWordsWithMaxLength()
	{
		List<String> wordsWithMaxLength = new ArrayList<String>();

		int maxLength = 1;

		for (String word : this.words)
		{
			int length = word.length();

			if (maxLength == length)
			{
				wordsWithMaxLength.add(word);
			}
			else if (maxLength < length)
			{
				maxLength = length;

				wordsWithMaxLength.clear();
				wordsWithMaxLength.add(word);
			}
		}

		return wordsWithMaxLength;
	}

	@Override
	public void processWords()
	{
		this.words.clear();

		for (String line : this.source)
		{
			String word = "";

			for (int i = 0, length = line.length(); i < length; i++)
			{
				char letter = line.charAt(i);

				if (!this.delimiters.contains(letter))
				{
					if (word.length() >= this.wordLength)
					{
						this.words.add(word);

						word = "";
					}

					word += letter;
				}
				else if (word.length() > 0)
				{
					this.words.add(word);

					word = "";
				}
			}

			if (word.length() > 0)
			{
				this.words.add(word);
			}
		}
	}

	@Override
	public void setDelimiters(List<Character> delimiters)
	{
		if (delimiters == null)
		{
			throw new IllegalArgumentException("Argument is null: delimiters");
		}

		this.delimiters = delimiters;
	}

	@Override
	public void setSource(List<String> source)
	{
		if (source == null)
		{
			throw new IllegalArgumentException("Argument is null: source");
		}

		this.source = source;

	}

	@Override
	public void setWordLength(int length)
	{
		if (length <= 0)
		{
			throw new IllegalArgumentException(
					"Argument is less or equal to zero: length");
		}

		this.wordLength = length;
	}

}
