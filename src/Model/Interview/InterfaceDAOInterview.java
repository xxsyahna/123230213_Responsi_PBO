package Model.Interview;

import java.util.List;

public interface InterfaceDAOInterview {

    public void insert(ModelInterview interview);

    public void update(ModelInterview interview);

    public void delete(int id);

    public List<ModelInterview> getAll();
}
