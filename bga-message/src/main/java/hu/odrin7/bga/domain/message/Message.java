package hu.odrin7.bga.domain.message;

import com.google.common.base.Objects;
import hu.odrin7.bga.domain.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Message {

    private long messageId;
    private String title;
    private String content;
    private String authorId;
    private LocalDateTime timestamp;
    private List<ReadParam> readParams;

    private Message() {
    }

    private Message(long messageId,
                    String title,
                    String content,
                    String authorId,
                    LocalDateTime timestamp,
                    List<ReadParam> readParams) {
        this.messageId = messageId;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.timestamp = timestamp;
        this.readParams = readParams;

        read(authorId);
    }

    public static Message create(long id,String title,
                                 String content,
                                 String authorId,
                                 List<String> usernames) {
        List<ReadParam> readParams = new ArrayList<>();
        for (String username : usernames) {
            readParams.add(new ReadParam(username, false));
        }



        return new Message(id, title, content, authorId, LocalDateTime.now(), readParams);
    }

    public void read(String username) {
        readParams
            .stream()
            .filter(readParam -> readParam.getUsername() == username)
            .forEach(readParam -> readParam.read());
    }

    public long getMessageId() {
        return messageId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<ReadParam> getReadParams() {
        return readParams;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setReadParams(List<ReadParam> readParams) {
        this.readParams = readParams;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("messageId", messageId)
            .add("title", title)
            .add("content", content)
            .add("authorId", authorId)
            .add("timestamp", timestamp)
            .add("readParams", readParams)
            .toString();
    }
}
