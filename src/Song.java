import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Song implements Iterable<Note>{
	private ArrayList<Note> notes;
	public MelodyNote parent;
	
	public Song() {								
		notes = new ArrayList<Note>();
		this.parent = null;
	}

	public void add(Note note) {
		notes.add(note);
	}
	public void add(Note[] notes) {
		for(int i = 0; i < notes.length; i++) {
			this.notes.add(notes[i]);
		}
	}
	
	public ArrayList<Note> getNotes(){
		return notes;
	}
	
	public MelodyNote addSong(Song song2) {
		Page.numOfPages = 1;
		if(this.parent == null) {
			parent = new MelodyNote();
			parent.open();
			parent.add(this);
			parent.add(song2);
		}
		else {
			int pos = this.parent.getSongs().indexOf(this);
			this.parent.getSongs().add(pos + 1, song2);
		}
		song2.parent = parent;
		
		return this.parent;
	}
	
	@Override
	public Iterator<Note> iterator() {
		return new GetIterator();
	}
	private class GetIterator implements Iterator<Note>{

		int pos = 0;
		
		@Override
		public boolean hasNext() {
			return pos < notes.size();
		}

		@Override
		public Note next() {
			if(this.hasNext()) {
				Note current = notes.get(pos);
				pos++;
				return current;
			}
			throw new NoSuchElementException();
		}
	}
	
	public float compair(Song song2) {
		return Math.signum(this.notes.size() - song2.notes.size());
	}
	
	public void play() {
		for(Note note : notes) {
			if(note.getMusicalMood() == MusicalMood.major) System.out.print(note.getNoteSign().toString() + " ");
			else System.out.print(note.getNoteSign().toString().toLowerCase()  + " ");
		}
	}
	
	public void changeMood(MusicalMood mood) {
		changeMood(mood, 0, this.notes.size() - 1);
	}
	public void changeMood(MusicalMood mood, int start) {
		changeMood(mood, start, this.notes.size() - 1);
	}
	public void changeMood(MusicalMood mood, int start, int end) {
		for(int i = start; i <= end; i++) {	
			notes.get(i).setMusicalMood(mood);
		}
	}
}
