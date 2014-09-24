package java_string_parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordProcessorTests
{
	private IWordProcessor processor;

	@Test(expected = IllegalArgumentException.class)
	public void getDelimiters_DelimitersParamIsNull_ThrowsIllegalArgumentException()
	{
		this.processor.setDelimiters(null);
	}

	@Test
	public void getDelimiters_ParameterIsNotSet_ReturnsEmptyArray()
	{
		Assert.assertEquals(new ArrayList<Character>(),
				this.processor.getDelimiters());
	}

	@Test
	public void getSource_SourceIsNotSet_ReturnsEmptyArray()
	{
		Assert.assertEquals(new ArrayList<String>(), this.processor.getSource());
	}

	@Test(expected = IllegalArgumentException.class)
	public void getSource_SourceParamIsNull_ThrowsIllegalArgumentException()
	{
		this.processor.setSource(null);
	}

	@Test
	public void getWordsWithMaxLength_ReturnsValidList()
	{
		final char delimiter = ';';

		this.processor.setDelimiters(new ArrayList<Character>()
				{
			{
				this.add(delimiter);
			}
				});

		List<String> wordsList = new ArrayList<String>()
				{
			{
				this.add("alpha");
				this.add("gamma");
				this.add("delta");
			}

				};

				List<String> source = new ArrayList<String>();

				for (String word : wordsList)
				{
					source.add(String.format("beta%1$s%2$s%1$szeta%1$s", delimiter,
					word));
				}

		this.processor.setSource(source);

		this.processor.processWords();

				Assert.assertEquals(wordsList, this.processor.getWordsWithMaxLength());
	}

	@Test
	public void getWordsWithMaxLength_WordsListIsEmpty_ReturnsEmptyList()
	{
		Assert.assertEquals(new ArrayList<String>(),
				this.processor.getWordsWithMaxLength());
	}

	@Test
	public void processWords_ParsesWordsFromSource()
	{
		List<Character> delimiters = new ArrayList<Character>()
		{
			{
				this.add(';');
				this.add('#');
				this.add(' ');
			}
		};

		List<String> words = new ArrayList<String>()
		{
			{
				this.add("w");
				this.add("wo");
				this.add("wor");
				this.add("word");
				this.add("word1");
			}
		};

		this.processor.setDelimiters(delimiters);

		StringBuilder stringBuilder = new StringBuilder();

		int delimitersCount = delimiters.size();

		for (int i = 0, count = words.size(); i < count; i++)
		{
			int delimeterIndex = (int) (Math.random() * delimitersCount);

			stringBuilder.append(words.get(i)).append(
					delimiters.get(delimeterIndex));
		}

		final String line = stringBuilder.toString();

		this.processor.setSource(new ArrayList<String>()
		{
			{
				this.add(line);
			}
		});

		this.processor.processWords();

		Assert.assertEquals(words, this.processor.getWords());
	}

	@Test
	public void processWords_SourceContainsOnlyFromDelimiters_WordsListWillBeEmpty()
	{
		List<Character> delimiters = new ArrayList<Character>()
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
		};

		this.processor.setDelimiters(delimiters);

		final StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0, count = delimiters.size(); i < count; i++)
		{
			stringBuilder.append(delimiters.get(i));
		}

		this.processor.setSource(new ArrayList<String>()
		{
			{
				this.add(stringBuilder.toString());
			}
		});

		this.processor.processWords();

		Assert.assertEquals(new ArrayList<String>(), this.processor.getWords());
	}

	@Test
	public void processWords_SourceIsEmpty_WordsListWillBeEmpty()
	{
		List<String> source = new ArrayList<String>();

		this.processor.setSource(source);

		this.processor.processWords();

		Assert.assertEquals(new ArrayList<String>(), this.processor.getWords());
	}

	@Test
	public void processWords_WordLengthIsBiggerThatMax_SplitsTheWord()
	{
		List<String> words = new ArrayList<String>()
		{
			{
				this.add("aaa");
				this.add("bbb");
				this.add("ccc");
				this.add("dd");
			}
		};

		this.processor.setWordLength(3);

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0, count = words.size(); i < count; i++)
		{
			stringBuilder.append(words.get(i));
		}

		final String line = stringBuilder.toString();

		this.processor.setSource(new ArrayList<String>()
		{
			{
				this.add(line);
			}
		});

		this.processor.processWords();

		Assert.assertEquals(words, this.processor.getWords());
	}

	@Before
	public void setUp()
	{
		this.processor = new WordProcessor();

		this.processor.setWordLength(5);
	}

	@Test
	public void setWordLength_LengthIsInvalid_ThrowsIllegalArgumentException()
	{
		try
		{
			this.processor.setWordLength(0);

			this.processor.setWordLength(-1);

			Assert.fail();
		}
		catch (IllegalArgumentException exception)
		{

		}
	}

}
