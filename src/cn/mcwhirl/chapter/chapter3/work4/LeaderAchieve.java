package cn.mcwhirl.chapter.chapter3.work4;

public class LeaderAchieve extends Leader{

    public LeaderAchieve(String name) {
        super(name);
    }

    @Override
    public void callback(String workerName, String result) {
        System.out.println(workerName+ "回应" + getName() + ": " + result);
    }
}