package com.google;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  Video nowPlaying = null; // Video currently playing.
  boolean paused = false; // Paused status.

  private TreeMap<String, VideoPlaylist> videoPlaylists = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    List<Video> videos = videoLibrary.getVideos(); // List of videos

    // Sort videos (uses the compareTo() method in Video class)
    Collections.sort(videos);

    System.out.println("Here's a list of all available videos:");

    videos.forEach(video -> System.out.println(video.toString()));
  }

  public void playVideo(String videoId) {
    List<Video> videos = videoLibrary.getVideos(); // List of videos

    Video foundVideo = videos.stream()
            .filter(video -> videoId.equals(video.getVideoId()))
            .findAny()
            .orElse(null);

    if (foundVideo == null) {
      // If no video is found...
      System.out.println("Cannot play video: " + "Video does not exist");
      return; // end method here.
    }
    if (nowPlaying != null) {
      // If there is another video playing...
      System.out.println("Stopping video: " + nowPlaying.getTitle());
    }
    paused = false;
    nowPlaying = foundVideo; // Set current video to the video found.
    System.out.println("Playing video: " + nowPlaying.getTitle());
  }

  public void stopVideo() {
    if (nowPlaying == null) {
      System.out.println("Cannot stop video: " + "No video is currently playing");
      return; // End function here
    }
    System.out.println("Stopping video: " + nowPlaying.getTitle());
    nowPlaying = null; // Set current video to null.
  }

  public void playRandomVideo() {
    List<Video> videos = videoLibrary.getVideos(); // Get videos list

    // If no videos
    if (videos.isEmpty()) {
      System.out.println("No videos available");
      return;
    }

    // Generate random number
    // int randomNumber = ThreadLocalRandom.current().nextInt(0, videoLibrary.getVideos().size());
    Random random = new Random();
    int randomNumber = random.nextInt(videoLibrary.getVideos().size());

    // Find the random video
    Video randomVideo = videos.get(randomNumber);

    // Play the random video
    playVideo(randomVideo.getVideoId());
  }

  public void pauseVideo() {
    if (nowPlaying == null) {
      // If no video is playing...
      System.out.println("Cannot pause video: " + "No video is currently playing");
      return; // end here
    }

    if (paused) {
      // If video is already paused...
      System.out.println("Video already paused: " + nowPlaying.getTitle());
      return; // end here
    }

    System.out.println("Pausing video: " + nowPlaying.getTitle());
    paused = true; // Pause video.
  }

  public void continueVideo() {
    if (nowPlaying == null) {
      // If nothing is playing...
      System.out.println("Cannot continue video: " + "No video is currently playing");
      return; // end here
    }

    if (!paused) {
      // If video is not paused...
      System.out.println("Cannot continue video: " + "Video is not paused.");
      return; // end here
    }

    System.out.println("Continuing video: " + nowPlaying.getTitle());
    paused = false; // Set video to not paused.
  }

  public void showPlaying() {
    if (nowPlaying == null) {
      // If no video playing...
      System.out.println("No video is currently playing");
      return; // end here
    }

    System.out.print("Currently playing: " + nowPlaying.toString());

    // Add paused marker if paused.
    if (paused) System.out.print(" - PAUSED\n");
  }

  public void createPlaylist(String playlistName) {
    if (videoPlaylists.get(playlistName) != null) {
      System.out.println("Cannot create playlist: " + "A playlist with the same name already exists");
      return;
    }
    videoPlaylists.put(playlistName, new VideoPlaylist(playlistName));
    System.out.println("Successfully created new playlist: " + videoPlaylists.get(playlistName).getName());
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}