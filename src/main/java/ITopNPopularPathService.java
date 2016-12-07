import java.util.List;

/**
 * Created by kobe73er on 16/12/7.
 */
public interface ITopNPopularPathService {

    void setup();

    List<String> getTopNPopularPathes(int n);
}