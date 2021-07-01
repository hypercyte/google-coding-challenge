package com.google;

import java.util.Collections;
import java.util.List;

/** A class used to represent a video. */
class Video implements Comparable<Video> {

  private final String title;
  private final String videoId;
  private final List<String> tags;

  Video(String title, String videoId, List<String> tags) {
    this.title = title;
    this.videoId = videoId;
    this.tags = Collections.unmodifiableList(tags);
  }

  /** Returns the title of the video. */
  String getTitle() {
    return title;
  }

  /** Returns the video id of the video. */
  String getVideoId() {
    return videoId;
  }

  /** Returns a readonly collection of the tags of the video. */
  List<String> getTags() {
    return tags;
  }

  @Override
  public int compareTo(Video v) {
    // When sorting, compare titles.
    return this.title.compareTo(v.getTitle());
  }

  @Override
  public String toString() {
    // Create new string to build on up until tags are needed.
    StringBuilder metadata = new StringBuilder(this.title + " (" + this.videoId + ") " + '[');

    // Add each tag.
    for (String tag : tags) {
      metadata.append(tag); // Add tag
      if (tags.indexOf(tag) != tags.size() - 1) metadata.append(" "); // Add space if not the last tag in list.
    }
    metadata.append(']'); // Close tags bracket.

    return metadata.toString(); // Return the metadata.
  }
}
