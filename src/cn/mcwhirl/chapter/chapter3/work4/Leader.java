package cn.mcwhirl.chapter.chapter3.work4;

public abstract class Leader {
    private String name;

    public Leader() {
    }

    public Leader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract void callback(String workerName, String result);

}
