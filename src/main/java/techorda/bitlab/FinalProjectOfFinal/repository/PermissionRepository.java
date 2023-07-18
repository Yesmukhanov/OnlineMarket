package techorda.bitlab.FinalProjectOfFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techorda.bitlab.FinalProjectOfFinal.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
