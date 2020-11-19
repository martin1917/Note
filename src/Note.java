public class Note {
	private NoteSign sign; //нота
	private MusicalMood mood; //мажор или минор
	
	public Note(NoteSign sign) {
		this.sign = sign;
		this.mood = MusicalMood.major;
	}
	
	public Note(NoteSign sign, MusicalMood mood) {
		this.sign = sign;
		this.mood = mood;
	}

	public float compair(Note note) {
		float ans = 0;
		if(this.sign.ordinal() != note.sign.ordinal()) {
			ans = Math.signum(this.sign.ordinal() - note.sign.ordinal());
		}
		else {
			if(this.mood == MusicalMood.major && note.mood != MusicalMood.major) ans = 1;
			else if(this.mood != MusicalMood.major && note.mood == MusicalMood.major) ans = -1;
			else ans = 0;
		}
		return ans;
	}
	
	public void setMusicalMood(MusicalMood mood) {
		this.mood = mood;
	}

	public MusicalMood getMusicalMood() {
		return this.mood;
	}
	
	public NoteSign getNoteSign() {
		return this.sign;
	}
	
	@Override
	public String toString() {
		String str = "";
		if(this.mood == MusicalMood.major) str = this.sign.toString();
		else str = this.sign.toString().toLowerCase();
		return str;
	}
}
