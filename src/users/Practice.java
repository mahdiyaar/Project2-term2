package users;

import java.util.ArrayList;

public class Practice {

    private String name;

    public ArrayList<String> questions = new ArrayList<String>();

    public Practice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
