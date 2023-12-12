package vn.edu.iuh.fit.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entites.Experience;

@Repository
public interface ExperienceReponsitory extends JpaRepository<Experience,Long> {

}
