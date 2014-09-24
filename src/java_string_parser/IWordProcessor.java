package java_string_parser;

import java.util.List;

public interface IWordProcessor
{
	/**
	 * Gets the delimiters.
	 *
	 * @return the delimiters
	 */
	List<Character> getDelimiters();

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	List<String> getSource();

	/**
	 * Gets the word length.
	 *
	 * @return the word length
	 */
	int getWordLength();

	/**
	 * Gets the words.
	 *
	 * @return the list of words
	 */
	List<String> getWords();

	/**
	 * Gets the list of words with max length.
	 *
	 * @return the list of words with max length
	 */
	List<String> getWordsWithMaxLength();

	/**
	 * Parses the words from the source.
	 */
	void processWords();

	/**
	 * Sets the delimiters.
	 *
	 * @param delimiters
	 *            the new delimiters
	 */
	void setDelimiters(List<Character> delimiters);

	/**
	 * Sets the source.
	 *
	 * @param source
	 *            the new source
	 */
	void setSource(List<String> source);

	/**
	 * Sets the word length.
	 *
	 * @param the
	 *            word length
	 */
	void setWordLength(int length);
}
