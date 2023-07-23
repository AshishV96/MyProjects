package net.relation.mapping.repository;

import net.relation.mapping.entity.Catagory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepository extends JpaRepository<Catagory,String> {
}
