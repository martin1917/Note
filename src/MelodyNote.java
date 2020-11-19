import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MelodyNote implements Iterable<Song>{
	private ArrayList<Song> songs;
	private boolean isOpen;
	
	public MelodyNote() {
		songs = new ArrayList<Song>();
		isOpen = false;
	}
	
	public void open() {
		isOpen = true;
	}
	
	public ArrayList<Song> getSongs() {
		return songs;
	}
	
	public void add(Song song) {
		if(isOpen) {
			this.songs.add(song);
			if(this.songs.size() > 0) song.parent = this.songs.get(songs.size() - 1).parent;
			else song.parent = this;
		}
		else {
			System.out.println("Тетрадь закрыта");
		}
	}

	@Override
	public Iterator<Song> iterator() {
		isOpen = true;
		return new GetIterator();
	}
	private class GetIterator implements Iterator<Song>{
		int pos = 0;
		
		@Override
		public boolean hasNext() {
			return pos < songs.size();
		}

		@Override
		public Song next() {
			if(this.hasNext()) {
				Song current = songs.get(pos);
				pos++;
				return current;
			}
			throw new NoSuchElementException();
		}
		
	}
}
