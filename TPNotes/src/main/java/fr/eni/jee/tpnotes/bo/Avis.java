package fr.eni.jee.tpnotes.bo;

public class Avis {
	private int note;
	private String description;
	
	public Avis(int note, String description) {
		super();
		this.note = note;
		this.description = description;
	}
	
	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	

}
