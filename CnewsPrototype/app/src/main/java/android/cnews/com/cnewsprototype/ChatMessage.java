package android.cnews.com.cnewsprototype;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by USER on 11/10/2017.
 */

public class ChatMessage{
    private String id;
    private String senderId;
    private String message;
    private Long timestamp;

    private boolean isMe;
    private String dateTime;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public boolean getIsme() {
        return isMe;
    }
    public void setMe(boolean isMe) {
        this.isMe = isMe;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getSenderId() {
        return senderId;
    }
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
    public String getDate() {
        return dateTime;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        Date newDate = new Date();
        newDate.setTime(newDate.getTime()+timestamp);
        this.dateTime = DateFormat.getDateTimeInstance().format(new Date(newDate.getTime()));
    }
}
