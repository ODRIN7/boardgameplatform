package hu.odrin7.bga.domain.message;

import hu.odrin7.bga.domain.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Message {

    public static long seq = 1123L;

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

    public static Message create(String title,
                                 String content,
                                 String authorId,
                                 List<User> users) {

        List<String> usernames = users.stream().map(User::getUsername).collect(Collectors.toList());
        List<ReadParam> readParams = new ArrayList<>();
        for (String username : usernames) {
            readParams.add(new ReadParam(username, false));
        }



        return new Message(seq++, title, content, authorId, LocalDateTime.now(), readParams);
    }

    public void read(String username) {
        readParams
            .stream()
            .filter(readParam -> readParam.getUsername() == username)
            .forEach(readParam -> readParam.read());
    }

    public static long getSeq() {
        return seq;
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
}
