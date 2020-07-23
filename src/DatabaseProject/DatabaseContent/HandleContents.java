package DatabaseProject.DatabaseContent;

import java.util.HashMap;
import java.util.ArrayList;

public interface HandleContents {
    public void changeStatus(Status newStatus);
    // First array List is the name if the DatabaseContent Object, the second parameter is the values I am returning
    HashMap<ArrayList<String>, HashMap<String, String>>returnData();

    void update(String identifier, DatabaseContent updatedObject);


}
