package models;

public class Video{

	private String title;
	private Category category;
	private double gainPerView;
	private int views;

	public Video(String title,Category category){
		this.title = title;
		this.category = category;
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