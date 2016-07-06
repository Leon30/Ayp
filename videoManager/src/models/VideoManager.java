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

	public printVideo(int pos){
		System.out.println("Title: " + videos[pos].getTitle() + "Category: " + videos[pos].getCategory());
	}

	public void printVideos(){
		for (int i = 0; i < videos.length; i++) {
			printVideo(i);
		}
	}

	public void printMostWiewed(){
		int pastViews = 0;
		int noNullVideos = 0;
		for (int i = 0; i < videos.length; i++) {
			if(videos[i] != null){
				if (i =! 0) {
					
				}
				if (videos[i].views > noNullVideos) {
					
				}
				noNullVideos++;
			}
		}
	}

	public static void main(String[] args) {
		VideoManager vm = new VideoManager();
		vm.addVideo(0, new Video("review",Category.TECH));
		vm.addVideo(1, new Video("song",Category.MUSIC));
		vm.printVideos();
	}
}