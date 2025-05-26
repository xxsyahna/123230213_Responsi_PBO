package Model.Writing;

import java.util.List;

public interface InterfaceDAOWriting {

    public void insert(ModelWriting writing);

    public void update(ModelWriting writing);

    public void delete(int id);

    public List<ModelWriting> getAll();
}
