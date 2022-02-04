package kata_socialnetwork.domain;

import java.util.concurrent.TimeUnit;

public class Message {
  private final String text;
  private final long publishedTime;
  private String username;

  public Message(String text, long publishedTime, String username) {
    this.text = text;
    this.publishedTime = publishedTime;
    this.username = username;
  }

  public String getText() {
    return text;
  }

  public String formatForViewTimeline(long timeOfReading) {
    return text + getElapsedTime(timeOfReading);
  }

  private String getElapsedTime(long now) {
    long elapsedTime = now - publishedTime;
    long elapsedMinutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTime);
    long elapsedSeconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime);

    if (elapsedMinutes > 0) {
      String minutesString = elapsedMinutes == 1 ? "minute" : "minutes";
      return String.format(" (%d %s ago)", elapsedMinutes, minutesString);
    }

    if (elapsedSeconds > 0) {
      String secondsString = elapsedSeconds == 1 ? "second" : "seconds";
      return String.format(" (%d %s ago)", elapsedSeconds, secondsString);
    }

    return "";
  }

  public void showTimelineOnConsole(long timeOfReading) {
    System.out.println(formatForViewTimeline(timeOfReading));
  }

  public String formatForWall(long timeOfWall) {
    return username + " - " + formatForViewTimeline(timeOfWall);
  }

  public void showWallOnConsole(long timeOfWall) {
    System.out.println(formatForWall(timeOfWall));
  }
}
