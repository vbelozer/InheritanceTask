package task3;

public class Dish {
    private boolean dirty = true;

    private String pattern = "flowers";

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty){
        this.dirty = dirty;
    }

    public String getPattern() {
        return this.pattern;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "pattern = '" + pattern + '\'' +
                ", is dirty = '" + dirty + '\'' +
                '}';
    }
}
