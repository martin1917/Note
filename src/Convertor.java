import java.util.ArrayList;

public class Convertor {
	public ArrayList<Page> convertToPages(Song song, int countNontesOnPage){
		ArrayList<Page> pages = new ArrayList<>(); //список страниц
		int i; //номер страницы
		for(i = 0; (i+1)*countNontesOnPage <= song.getNotes().size(); i++) { //пока суммарное кол-во нот на —“–јЌ»÷ј’ < всех нот в песне
			Page page = new Page(countNontesOnPage); //создаем новую страинцу

			if(pages.size() > 0) pages.get(i-1).setNextPage(page); //если уже есть страницы, то сделать ссылку на текущую страницу
			for(int j = i*countNontesOnPage; j < (i+1)*countNontesOnPage; j++) { //заполн€ем страницу
				page.add(song.getNotes().get(j)); //добавл€ем страницу в список
			}
			if(pages.size() > 0) page.setPrevPage(pages.get(i-1)); ////если уже есть страницы, то сделать ссылку на пред. страницу
			pages.add(page);
		}
		
		if(song.getNotes().size() % countNontesOnPage != 0) {//если остались ноты, не заполн€ющие страницу полностью, то запиываем сколько осталось на новую страницу
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
