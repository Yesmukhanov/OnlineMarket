package techorda.bitlab.FinalProjectOfFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techorda.bitlab.FinalProjectOfFinal.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
