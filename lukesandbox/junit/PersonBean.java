package lukesandbox.junit;

/**
 * Created by Lucas on 10/26/2015.
 */
public class PersonBean {
    private String name = "Luke";

    public PersonBean(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
