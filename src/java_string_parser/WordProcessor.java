package java_string_parser;

import java.util.ArrayList;
import java.util.List;

public class WordProcessor implements IWordProcessor
{
	private char[] delimiters;

	private List<String> source;

	private int wordLength;

	private List<String> words;

	public WordProcessor()
	{
		this.delimiters = new char[0];
		this.source = new ArrayList<String>();
		this.words = new ArrayList<String>();
		this.wordLength = 1;
	}

	@Override
	public char[] getDelimiters()
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
	}

	@Override
	public void setDelimiters(char[] delimiters)
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
