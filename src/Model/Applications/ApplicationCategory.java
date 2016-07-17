package Model.Applications;

/**
 * Created by ALDO on 16/7/2016.
 */
public class ApplicationCategory {
    private int applicationCategoryId;
    private String applicationCategoryName;

    public int getApplicationCategoryId() {
        return applicationCategoryId;
    }

    public void setApplicationCategoryId(int applicationCategoryId) {
        this.applicationCategoryId = applicationCategoryId;
    }

    public String getApplicationCategoryName() {
        return applicationCategoryName;
    }

    public void setApplicationCategoryName(String applicationCategoryName) {
        this.applicationCategoryName = applicationCategoryName;
    }

    public ApplicationCategory()
    {
        this.applicationCategoryId = 0;
        this.applicationCategoryName = "";
    }
    public ApplicationCategory(String applicationCategoryName)
    {
        this.applicationCategoryId = 0;
        this.applicationCategoryName = applicationCategoryName;
    }
    public boolean save()
    {
        System.out.printf("method will implements");
        return true;
    }
    public boolean update()
    {
        System.out.printf("method will implements");
        return true;
    }
    public boolean delete()
    {
        System.out.printf("method will implements");
        return true;
    }
    public  static ApplicationCategory getApplicationCategory(int applicationCategoryId)
    {
        ApplicationCategory applicationCategory = new ApplicationCategory("Work");
        return applicationCategory;
    }
}
