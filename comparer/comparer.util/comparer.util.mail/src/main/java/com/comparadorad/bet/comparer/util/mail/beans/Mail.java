package com.comparadorad.bet.comparer.util.mail.beans;

public class Mail {
	/** The subject. */
	private String subject;

	/** The text. */
	private String text;

	/** The to. */
	private String to;

	/**
	 * Instantiates a new mail.
	 */
	public Mail() {
	}

	/**
	 * Instantiates a new mail.
	 * 
	 * @param to
	 *            the to
	 * @param text
	 *            the text
	 * @param subject
	 *            the subject
	 */
	public Mail(String to, String text, String subject) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Gets the text.
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the to.
	 * 
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the subject.
	 * 
	 * @param subject
	 *            the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Sets the text.
	 * 
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Sets the to.
	 * 
	 * @param to
	 *            the new to
	 */
	public void setTo(String to) {
		this.to = to;
	}
}
