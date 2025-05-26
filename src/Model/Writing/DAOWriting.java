package Model.Writing

import Model.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOWriting implements InterfaceDAOWriting {

    @Override
    public void insert(ModelWriting  writing) {
        try {
            String query = "INSERT INTO writing (nama, path, score, status) VALUES (?, ?, ?, ?);";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, writing.getNama());
            statement.setString(2, writing.getPath());
            statement.setString(3, writing.getScore());
            statement.setString(4, writing.getStatus());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelWriting  writing) {
        try {
            String query = "UPDATE writing SET nama=?, path=?, score=?, status=? WHERE id=?;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, writing.getNama());
            statement.setString(2, writing.getPath());
            statement.setString(3, writing.getScore());
            statement.setString(4, writing.getStatus());
            statement.setInt(5, writing.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Update Failed! (" + e.getLocalizedMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM writing WHERE id=?;";
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
    public List<ModelWriting > getAll() {
        List<ModelWriting > listWriting = null;

        try {
            listWriting = new ArrayList<>();

            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM writing;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ModelWriting  writing = new ModelWriting ();

                writing.setId(resultSet.getInt("id"));
                writing.setNama(resultSet.getString("nama"));
                writing.setPath(resultSet.getString("path"));
                writing.setScore(resultSet.getString("score"));
                writing.setStatus(resultSet.getString("status"));
                listWriting.add(writing);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listWriting ;
    }
}
