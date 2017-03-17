package hu.odrin7.bga.domain.message;

public class ReadParam {

    private String username;
    private boolean isRead;

    public ReadParam(String username, boolean isRead) {
        this.username = username;
        this.isRead = isRead;
    }

    public ReadParam() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public String getUsername() {
        return username;
    }

    public boolean isRead() {
        return isRead;
    }

    public void read() {
        isRead = true;
    }
}
