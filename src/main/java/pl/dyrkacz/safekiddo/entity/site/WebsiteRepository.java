package pl.dyrkacz.safekiddo.entity.site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends JpaRepository<Website,String> {

    @Override
    boolean existsById(String name);

    void deleteBySiteName(String name);
}
