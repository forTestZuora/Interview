/**
 * Created by kobe73er on 16/12/7.
 */
class User {
    private int id;
    private String name;
    private String gender;


    public User(int id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

public class UserAndVisitPath {
    private User user;
    private String visitedPath;

    public UserAndVisitPath(User user, String visitedPath) {
        this.user = user;
        this.visitedPath = visitedPath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getVisitedPath() {
        return visitedPath;
    }

    public void setVisitedPath(String visitedPath) {
        this.visitedPath = visitedPath;
    }
}
