package com.google;

import java.util.List;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private final String name;
    private List<Video> videos;

    public VideoPlaylist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
