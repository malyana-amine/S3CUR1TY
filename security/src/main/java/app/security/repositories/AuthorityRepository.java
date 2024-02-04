package app.security.repositories;


import app.security.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    @Query(value = "select * from authority where name in %:authorities%", nativeQuery = true)
    List<Authority> findAllByName(@Param("authorities") List<String> authorities);
}
