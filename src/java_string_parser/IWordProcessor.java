package java_string_parser;

import java.util.List;

public interface IWordProcessor
{
	/**
	 * Gets the delimiters.
	 *
	 * @return the delimiters
	 */
	char[] getDelimiters();

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	List<String> getSource();

	/**
	 * Gets the words with max length.
	 *
	 * @return the words with max length
	 */
	List<String> getWordsWithMaxLength();

	/**
	 * Process words.
	 */
	void processWords();

	/**
	 * Sets the delimiters.
	 *
	 * @param delimiters
	 *            the new delimiters
	 */
	void setDelimiters(char[] delimiters);

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

	/**
	 * Gets the word length.
	 *
	 * @return the word length
	 */
	int getWordLength();
}
