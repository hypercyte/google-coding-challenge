package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private final String name;
    private List<Video> videos = new ArrayList<>();

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
