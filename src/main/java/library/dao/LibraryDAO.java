package library.dao;

import library.model.Library;
import library.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAO {
    public List<Library> getAllLibraries() {
        List<Library> libraries = new ArrayList<>();
        String sql = "SELECT * FROM libraries";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                libraries.add(new Library(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libraries;
    }
}