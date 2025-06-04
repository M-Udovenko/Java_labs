package org.example.webapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatDAO {

    // Створення таблиці при першому запуску
    public void createTableIfNotExists() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS cats (
                id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                breed VARCHAR(100),
                age INTEGER,
                color VARCHAR(50)
            )
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'cats' created or already exists");

        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // Додавання нового кота
    public boolean addCat(Cat cat) {
        String insertSQL = "INSERT INTO cats (name, breed, age, color) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, cat.getName());
            pstmt.setString(2, cat.getBreed());
            pstmt.setInt(3, cat.getAge());
            pstmt.setString(4, cat.getColor());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error adding cat: " + e.getMessage());
            return false;
        }
    }

    // Отримання всіх котів
    public List<Cat> getAllCats() {
        List<Cat> cats = new ArrayList<>();
        String selectSQL = "SELECT id, name, breed, age, color FROM cats ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                Cat cat = new Cat(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("breed"),
                        rs.getInt("age"),
                        rs.getString("color")
                );
                cats.add(cat);
            }

        } catch (SQLException e) {
            System.err.println("Error getting cats: " + e.getMessage());
        }

        return cats;
    }

    // Отримання кота за ID
    public Cat getCatById(Long id) {
        String selectSQL = "SELECT id, name, breed, age, color FROM cats WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setLong(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Cat(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("breed"),
                            rs.getInt("age"),
                            rs.getString("color")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Error getting cat by id: " + e.getMessage());
        }

        return null;
    }
}