package Model.Coding;

import java.util.List;

public interface InterfaceDAOCoding {

    public void insert(ModelCoding coding);

    public void update(ModelCoding coding);

    public void delete(int id);

    public List<ModelCoding> getAll();
}
