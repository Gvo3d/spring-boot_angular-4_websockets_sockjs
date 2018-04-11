package hello.dto;

public class SubscribedMessage {
    private String identity;
    private String name;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubscribedMessage{" +
                "identity='" + identity + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
