package ua.edu.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.edu.lab7.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}