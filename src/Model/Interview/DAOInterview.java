package Model.Interview

import Model.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOInterview implements InterfaceDAOInterview {

    @Override
    public void insert(ModelInterview interview) {
        try {
            String query = "INSERT INTO interview (nama, path, score, status) VALUES (?, ?, ?, ?);";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, interview.getNama());
            statement.setString(2, interview.getPath());
            statement.setString(3, interview.getScore());
            statement.setString(4, interview.getStatus());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelInterview interview) {
        try {
            String query = "UPDATE interview SET nama=?, path=?, score=?, status=? WHERE id=?;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, interview.getNama());
            statement.setString(2, interview.getPath());
            statement.setString(3, interview.getScore());
            statement.setString(4, interview.getStatus());
            statement.setInt(5, interview.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Update Failed! (" + e.getLocalizedMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM interview WHERE id=?;";
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
    public List<ModelInterview> getAll() {
        List<ModelInterview> listInterview = null;

        try {
            listInterview = new ArrayList<>();

            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM Interview;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ModelInterview interview = new ModelInterview();

                interview.setId(resultSet.getInt("id"));
                interview.setNama(resultSet.getString("nama"));
                interview.setPath(resultSet.getString("path"));
                interview.setScore(resultSet.getString("score"));
                interview.setStatus(resultSet.getString("status"));
                listInterview.add(interview);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listInterview;
    }
}
