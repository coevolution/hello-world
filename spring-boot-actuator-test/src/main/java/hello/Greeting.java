package hello;

/**
 * @author lxp
 * @date 2019/6/26 下午4:10
 * @Version 1.0
 */
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
