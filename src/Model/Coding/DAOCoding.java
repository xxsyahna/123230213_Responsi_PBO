package Model.Coding;

import Model.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCoding implements InterfaceDAOCoding {

    @Override
    public void insert(ModelCoding coding) {
        try {
            String query = "INSERT INTO coding (nama, path, score, status) VALUES (?, ?, ?, ?);";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, coding.getNama());
            statement.setString(2, coding.getPath());
            statement.setString(3, coding.getScore());
            statement.setString(4, coding.getStatus());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelCoding coding) {
        try {
            String query = "UPDATE coding SET nama=?, path=?, score=?, status=? WHERE id=?;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, coding.getNama());
            statement.setString(2, coding.getPath());
            statement.setString(3, coding.getScore());
            statement.setString(4, coding.getStatus());
            statement.setInt(5, coding.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Update Failed! (" + e.getLocalizedMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM coding WHERE id=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelCoding> getAll() {
        List<ModelCoding> listCoding = null;

        try {
            listCoding = new ArrayList<>();

            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM coding;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ModelCoding coding = new ModelCoding();

                coding.setId(resultSet.getInt("id"));
                coding.setNama(resultSet.getString("nama"));
                coding.setPath(resultSet.getString("path"));
                coding.setScore(resultSet.getString("score"));
                coding.setStatus(resultSet.getString("status"));
                listCoding.add(coding);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listCoding;
    }
}
