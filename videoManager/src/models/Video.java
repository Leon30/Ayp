package models;

public class Video{

	private final String title;
	private final Category category;
	private final double gainPerView;
	private int views;

	public Video(String title, Category category, double gainPerView){
		this.title = title;
		this.category = category;
		this.gainPerView = gainPerView;
		views = 0;
	}

	public String getTitle(){
		return title;
	}

	public Category getCategory(){
		return category;
	}

	public int getViews(){
		return views;
	}

	public double getGainPerView(){
		return gainPerView;
	}

	public void upViews(){
		views++;
	}
}