package java_string_parser;

import java.util.ArrayList;
import java.util.List;

import java_string_parser.IWordProcessor;
import java_string_parser.WordProcessor;

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
		Assert.assertArrayEquals(new char[0], this.processor.getDelimiters());
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

	@Test
	public void getWordsWithMaxLength_WordsListIsEmpty_ReturnsEmptyList()
	{
		Assert.assertEquals(new ArrayList<String>(),
				this.processor.getWordsWithMaxLength());
	}

	@Test
	public void getWordsWithMaxLength_ReturnsValidList()
	{
		char delimiter = ';';

		this.processor.setDelimiters(new char[] { delimiter });

		List<String> wordsList = new ArrayList<String>()
		{
			{
				add("alpha");
				add("gamma");
				add("delta");
			}

		};

		List<String> source = new ArrayList<String>();

		for (String word : wordsList)
		{
			source.add(String.format("beta{0}{1}{0}zeta{0}", delimiter, word));
		}

		Assert.assertEquals(wordsList, this.processor.getWordsWithMaxLength());
	}

	@Before
	public void setUp()
	{
		this.processor = new WordProcessor();
	}

}
