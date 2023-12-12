package vn.edu.iuh.fit.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entites.Candidate;
import vn.edu.iuh.fit.entites.Role;

import java.util.List;

@Repository
public interface CandidateReponsitoty extends JpaRepository<Candidate, Long> {
    List<Candidate> findByEmailNotNull();
    @Query("SELECT distinct e.candidate FROM Experience e WHERE e.roles = ?1")
    List<Candidate> findCandidatesByExperienceRole(Role roles);


}
