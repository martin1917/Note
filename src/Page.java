public class Page extends Song{
	private int countNontesOnPage;
	static int numOfPages = 1; 
	private int numberOfPage; 
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

	public int getNumOfPages() {
		return numOfPages; 
	}
	
	public int getNumberOfPage() {
		return numberOfPage;
	}
	
	public int getÑountNontesOnPage() {
		return countNontesOnPage;
	}
	
	@Override
	public void play() {
		super.play();
		System.out.println("\n№ . " + this.numberOfPage + " \Count of notes: " + getNotes().size() + "\n");
	}
}
