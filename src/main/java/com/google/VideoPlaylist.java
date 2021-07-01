package com.google;

import java.util.List;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private final String name;
    private final String id;
    private final List<String> tags;

    public VideoPlaylist(String name, String id, List<String> tags) {
        this.name = name;
        this.id = id;
        this.tags = tags;
    }
}
