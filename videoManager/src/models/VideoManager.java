package models;

public class VideoManager{

	private Video[] videos;
	public static final int MAX_VIDEOS = 10;

	public VideoManager(){
		videos = new Video[MAX_VIDEOS];
	}

	public void addVideo(int pos, Video video){
		videos[pos] = video;
	}

	public void deleteVideo(int pos){
		videos[pos] = null;
	}

	public void printVideo(int pos){
		System.out.println("Title: " + videos[pos].getTitle() + " Category: " + videos[pos].getCategory());
	}

	public void printVideos(){
		for (int i = 0; i < videos.length; i++) {
			if(videos[i] != null){
				printVideo(i);
			}
		}
	}

	public void printMostWiewed(){
		int pastViews = 0;
		int noNullVideos = 0;
		int mostViewedVideo = 0;
		for (int i = 0; i < videos.length; i++) {
			if(videos[i] != null){
				if (noNullVideos > 1) {
					if (videos[i].getViews() > noNullVideos) {
						pastViews = videos[i].getViews();
						mostViewedVideo = videos[i].getViews();
					}
				}	
				noNullVideos++;
			}
		}
		printVideo(mostViewedVideo);
	}

	public static void main(String[] args) {
		VideoManager youtube = new VideoManager();
		youtube.addVideo(0, new Video("review",Category.TECH));
		youtube.addVideo(1, new Video("song",Category.MUSIC));
		System.out.print("Most Viewed: ");
		youtube.printMostWiewed();
		youtube.printVideos();
	}
}