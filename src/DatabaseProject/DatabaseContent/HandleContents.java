package DatabaseProject.DatabaseContent;

import java.util.HashMap;

public interface HandleContents {
    /**Changes the status of a DatabaseContent Object.
     * @param newStatus new status.*/

    void changeStatus(Status newStatus);
    /** Updates a DatabaseContent Object by changing the updatable Attributes to the corresponding
     * attributes in the updateObject.
     * @param identifier key for the Admin storage Hashmap.
     * @param updateObject new DatabaseContent Object with update values.
     * */
    void update(String identifier, DatabaseContent updateObject, HashMap<String, DatabaseContent> referenceAdminStore);

}
