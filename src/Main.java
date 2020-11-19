import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Note[] notes = new Note[50];
		for(int i = 0; i < notes.length; i++) {
			if(i % 2 == 0) notes[i] = new Note(NoteSign.values()[new Random().nextInt(7)]);
			else notes[i] = new Note(NoteSign.values()[new Random().nextInt(7)], MusicalMood.values()[new Random().nextInt(2)]);
		}
		System.out.println("NOTE |\n------\n1)compair\t" + notes[0].toString() + " > " + notes[15].toString() + ": " + notes[0].compair(notes[15]) + "\n");
		
		System.out.print("2)setMusicalMood\t" + notes[15].toString() + " ---> ");
		notes[15].setMusicalMood(MusicalMood.values()[1 - notes[15].getMusicalMood().ordinal()]);
		System.out.print(notes[15].toString() + "\n");
		
		System.out.println("=======================================================================================\n");
		
		
		
		Song[] songs = new Song[3];
		for(int i = 0; i < songs.length; i++) {
			songs[i] = new Song();
		}
		
		songs[0].add(notes);
		for(int i = 0; i < 126; i++) {
			if(i % 2 == 0) {
				Note note = new Note(NoteSign.values()[new Random().nextInt(7)]);
				songs[1].add(note);
			}
			else {
				Note note = new Note(NoteSign.values()[new Random().nextInt(7)], MusicalMood.values()[new Random().nextInt(2)]);
				songs[2].add(note);
			}
		}
		
		System.out.println("SONG |\n------\n1)compair\t" + songs[0].getNotes().size() + " > " + songs[1].getNotes().size() + ": " + songs[0].compair(songs[1]) + "\n");
		System.out.print("2)play:\t\t"); songs[0].play();
		
		System.out.print("\n\n\n3)changeMood.1:\t"); songs[0].changeMood(MusicalMood.major); songs[0].play();
		System.out.print("\n\n4)changeMood.2:\t"); songs[0].changeMood(MusicalMood.minor, 25); songs[0].play();
		System.out.print("\n\n5)changeMood.3:\t"); songs[0].changeMood(MusicalMood.major, 30, 40); songs[0].play();
		
		System.out.println("\n=======================================================================================\nMELODY_NOTE |\n-------------\n");
		
		
		
		
		Convertor convertor = new Convertor();
		MelodyNote melodyNote = songs[0].addSong(songs[2]);
		
		for(Song song : melodyNote) {
			for(Page page : convertor.convertToPages(song, 15)) {
				page.play();
			}
			System.out.println("\n");
		}
		System.out.print("днаюбхкх мнбсч оеямч б рерпюдэ\n--------------------------------------------------------------\n");
		
		melodyNote = songs[0].addSong(songs[1]);
		for(Song song : melodyNote) {
			for(Page page : convertor.convertToPages(song, 15)) {
				page.play();
			}
			System.out.println("\n");
		}
		
		
	}
}
enum NoteSign{ DO, RE, MI, FA, SOL, LYA, SI }
enum MusicalMood{ major, minor }