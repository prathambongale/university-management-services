package edu.university.universityofficeservices.repository;

import edu.university.universityofficeservices.models.OfficeLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeLoginRepository extends JpaRepository<OfficeLogin, String> {

    @Query(value = "SELECT uof.userId FROM university_office_login uof WHERE uof.email=?1 AND uof.cell=?2")
    String findByEmailAndCell(String email, String cell);
}
