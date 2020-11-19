import java.util.ArrayList;

public class Convertor {
	public ArrayList<Page> convertToPages(Song song, int countNontesOnPage){
		ArrayList<Page> pages = new ArrayList<>();
		int i; 
		for(i = 0; (i+1)*countNontesOnPage <= song.getNotes().size(); i++) { 
			Page page = new Page(countNontesOnPage); 

			if(pages.size() > 0) pages.get(i-1).setNextPage(page); 
			for(int j = i*countNontesOnPage; j < (i+1)*countNontesOnPage; j++) { 
				page.add(song.getNotes().get(j)); 
			}
			if(pages.size() > 0) page.setPrevPage(pages.get(i-1)); 
			pages.add(page);
		}
		
		if(song.getNotes().size() % countNontesOnPage != 0) {
			Page page = new Page(countNontesOnPage);
			if(pages.size() > 0) pages.get(i-1).setNextPage(page);
			for(int j = song.getNotes().size() - song.getNotes().size() % countNontesOnPage; j < song.getNotes().size(); j++) {
				page.add(song.getNotes().get(j));
			}
			if(pages.size() > 0) page.setPrevPage(pages.get(i-1));
			pages.add(page);
		}
		
		pages.get(0).setPrevPage(null);
		pages.get(pages.size() - 1).setNextPage(null);
		
		return pages;
	}
}
