package DatabaseProject.DatabaseContent;

public interface HandleContents {

    void changeStatus(Status newStatus);
    void update(String identifier, DatabaseContent updatedObject);


}
