package com.library.model;

public class AcademicBook extends Book {

	private String subject;

	public AcademicBook(int id, String title, String author, String subject) {
		super(id, title, author);

		if (subject.isEmpty() || !subject.matches("[a-zA-Z]+")) {

			throw new IllegalArgumentException("subject cannot be null");
		}
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	@Override
	public String getType() {

		return "Academic";
	}

}
