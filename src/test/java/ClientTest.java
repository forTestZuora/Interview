import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kobe73er on 16/12/7.
 */
public class ClientTest {
    private Task clientIns;
    ArrayList<UserAndVisitPath> userAndVisitPathList;

    @Before
    public void setUp() throws Exception {
        userAndVisitPathList = new ArrayList<UserAndVisitPath>();
        User Jack = new User(2, "Jack", "male");
        User Andrew = new User(3, "Andrew", "male");
        User Lily = new User(1, "Lily", "female");


        userAndVisitPathList.add(new UserAndVisitPath(Lily, "/"));
        userAndVisitPathList.add(new UserAndVisitPath(Lily, "subscibers"));
        userAndVisitPathList.add(new UserAndVisitPath(Lily, "filter"));
        userAndVisitPathList.add(new UserAndVisitPath(Lily, "export"));


        userAndVisitPathList.add(new UserAndVisitPath(Jack, "/"));
        userAndVisitPathList.add(new UserAndVisitPath(Jack, "subscibers"));
        userAndVisitPathList.add(new UserAndVisitPath(Jack, "filter"));
        userAndVisitPathList.add(new UserAndVisitPath(Jack, "export"));

        userAndVisitPathList.add(new UserAndVisitPath(Andrew, "/"));
        userAndVisitPathList.add(new UserAndVisitPath(Andrew, "catalog"));
        userAndVisitPathList.add(new UserAndVisitPath(Andrew, "edit"));
        clientIns = new Task(userAndVisitPathList);

    }

    @After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void getTopNPopularPathes() throws Exception {
        List<String> resultList = clientIns.getTopNPopularPathes(2);

        assertEquals("Visited Count: 2 Visited Paths:[/->subscibers->filter, subscibers->filter->export]", resultList.get(0));
        assertEquals("Visited Count: 1 Visited Paths:[/->catalog->edit]", resultList.get(1));


    }

}