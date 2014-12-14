package android_kaizen.com.customnavigationdrawer.model;

/**
 * Created by Andy on 10-Dec-14.
 */

public class ObjectDrawerItem {

    private int icon;
    private String name;

    public ObjectDrawerItem(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
