public class Page extends Song{
	private int countNontesOnPage; //Кол-во нот на странице
	static int numOfPages = 1; //кол-во страниц
	private int numberOfPage; //номер страницы
	private Page next;  
	private Page prev; 
	
	public Page(int countNontesOnPage) {
		this.countNontesOnPage = countNontesOnPage; 
		this.numberOfPage = numOfPages++;
	}
	
	public void setNextPage(Page next) {
		this.next = next;
	}
	public Page getNextPage() {
		return this.next;
	}
	
	public void setPrevPage(Page prev) {
		this.prev = prev;
	}
	public Page getPrevPage() {
		return this.prev;
	}

	public int getNumOfPages() {//вернуть кол-во страниц
		return numOfPages; 
	}
	
	public int getNumberOfPage() {//вернуть номер страницы
		return numberOfPage;
	}
	
	public int getСountNontesOnPage() {//вернуть кол-во нот на странице
		return countNontesOnPage;
	}
	
	@Override
	public void play() {
		super.play();
		System.out.println("\nСтр. " + this.numberOfPage + " \tКол-во нот: " + getNotes().size() + "\n");
	}
}