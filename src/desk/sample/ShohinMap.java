package desk.sample;

import java.math.BigDecimal;

public class ShohinMap {
	private Integer numid;

	private Short shohincode;

	private String shohinname;

	private BigDecimal editdate;

	private BigDecimal edittime;

	private String note;

	/*public ShohinMap() {
		super();
	}

	public ShohinMap(Short Code, String Name, BigDecimal Date, BigDecimal Time, String Note) {
		super();
		ShohinCode = Code;
		ShohinName = Name;
		EditDate = Date;
		EditTime = Time;
		this.Note = Note;
	}*/

	public Integer getNumId() {
		return numid;
	}

	public void setNumId(Integer value) {
		numid = value;
	}

	public Short getShohinCode() {
		return shohincode;
	}
	public void setShohinCode(Short value) {
		shohincode = value;
	}

	public String getShohinName() {
		return shohinname;
	}
	public void setShohinName(String value) {
		shohinname = value;
	}

	public BigDecimal getEditDate() {
		return editdate;
	}
	public void setEditDate(BigDecimal value) {
		editdate = value;
	}

	public BigDecimal getEditTime() {
		return edittime;
	}
	public void setEditTime(BigDecimal value) {
		edittime = value;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String value) {
		note = value;
	}

}
