package models;

public class VideoManager{

	private Video[] videos;
	public static final int MAX_VIDEOS = 10;

	public VideoManager(){
		videos = new Video[MAX_VIDEOS];
	}

	public void addVideo(Video video){
		int pos = 0;
		for (int i = 0; i < videos.length; i++) {
			if (videos[i] == null) {
				pos = i;
				break;
			}
		}
		videos[pos] = video;
	}

	public void deleteVideo(int pos){
		videos[pos] = null;
	}

	public void printVideo(int pos){
            System.out.println("Title: " + videos[pos].getTitle() + " Category: " + videos[pos].getCategory() + " Views: " + videos[pos].getViews());
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

	public double getTotalGain(){
            double totalGain = 0;
            for (int i = 0; i < videos.length && videos[i] != null; i++) {
                totalGain += videos[i].getViews() * videos[i].getGainPerView();
            }
            return totalGain;
	}

	public void playVideo(int videoNumber){
            videos[videoNumber].upViews();
	}

	public static void main(String[] args) {
            VideoManager youtube = new VideoManager();
            youtube.addVideo(new Video("review",Category.TECH, 100));
            youtube.addVideo(new Video("song",Category.MUSIC, 100));
            youtube.addVideo(new Video("how to",Category.TUTORIAL, 80));
            youtube.playVideo(0);
            youtube.playVideo(0);
            youtube.playVideo(0);
            youtube.playVideo(0);
            youtube.playVideo(1);
            youtube.playVideo(1);
            youtube.playVideo(1);
            System.out.print("Most Viewed: ");
            youtube.printMostWiewed();
            youtube.printVideos();
            System.out.println("Total gain: " + youtube.getTotalGain());
	}
}