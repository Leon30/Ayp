package models;

public class Video{

	private String title;
	private Category category;
	private String gain;
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
}