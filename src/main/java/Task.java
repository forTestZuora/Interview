import java.util.*;

/**
 * Created by kobe73er on 16/12/7.
 */
public class Task implements ITopNPopularPathService {
    private ArrayList<UserAndVisitPath> userAndVisitPathList;
    private Map<User, LinkedList<String>> userPathMap;
    private Map<Integer, LinkedList<String>> finalSortedMap;

    public Task(ArrayList<UserAndVisitPath> userAndVisitPathList) {
        this.userAndVisitPathList = userAndVisitPathList;
        userPathMap = new HashMap();
        finalSortedMap = new TreeMap<Integer, LinkedList<String>>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        setup();
    }


    public void setup() {
        initUserPathMap();
        getSortedMap(3);
    }

    public List<String> getTopNPopularPathes(int n) {
        Iterator it = finalSortedMap.entrySet().iterator();
        LinkedList<String> rList = new LinkedList<String>();
        while (it.hasNext()) {
            Map.Entry<Integer, LinkedList<String>> node = (Map.Entry<Integer, LinkedList<String>>) it.next();
            StringBuffer sb = new StringBuffer();
            sb.append("Visited Count: " + node.getKey());
            sb.append(" Visited Paths:" + node.getValue());
            sb.toString();

            rList.add(sb.toString());
        }
        return rList;
    }

    /**
     * initialize the the userPathMap
     */
    private void initUserPathMap() {
        for (UserAndVisitPath item : userAndVisitPathList) {
            User currentUser = item.getUser();
            if (userPathMap.get(currentUser) != null) {
                LinkedList<String> currentUserVisitedList = userPathMap.get(currentUser);
                currentUserVisitedList.add(item.getVisitedPath());
                userPathMap.put(currentUser, currentUserVisitedList);
            } else {
                LinkedList<String> currentUserVisitedList = new LinkedList<String>();
                currentUserVisitedList.add(item.getVisitedPath());
                userPathMap.put(currentUser, currentUserVisitedList);
            }
        }
    }

    /**
     * return the final sorted map which key is the total times of the path visited and value is the visited path itself
     *
     * @param count the count-page paths
     */
    private void getSortedMap(int count) {
        Map<String, Integer> sortedMap = new TreeMap<String, Integer>();

        Iterator it = userPathMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<User, LinkedList<String>> entry = (Map.Entry<User, LinkedList<String>>) it.next();
            LinkedList<String> valueList = entry.getValue();
            int index = 0;
            while (index <= valueList.size() - count) {
                List<String> pathList = valueList.subList(index, count + index);
                StringBuffer keyStyle = new StringBuffer();
                for (String node : pathList) {
                    keyStyle.append(node + "->");
                }
                keyStyle.delete(keyStyle.length() - 2, keyStyle.length());
                String path = keyStyle.toString();
                if (null != sortedMap.get(path)) {
                    Integer counter = sortedMap.get(path);
                    counter++;
                    sortedMap.put(path, counter);
                } else {
                    sortedMap.put(path, 1);
                }
                index++;
            }
        }

        Iterator it2 = sortedMap.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, Integer> entry2 = (Map.Entry<String, Integer>) it2.next();
            Integer newKey = entry2.getValue();
            if (null != finalSortedMap.get(newKey)) {
                LinkedList<String> tempList = finalSortedMap.get(newKey);
                tempList.add(entry2.getKey());
                finalSortedMap.put(newKey, tempList);
            } else {
                LinkedList<String> tempList = new LinkedList<String>();
                tempList.add(entry2.getKey());
                finalSortedMap.put(newKey, tempList);
            }
        }
    }
}
