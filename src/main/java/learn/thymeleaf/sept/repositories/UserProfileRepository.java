package learn.thymeleaf.sept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.thymeleaf.sept.entity.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
    @Query(value = "SELECT * FROM user_profile up WHERE up.full_name LIKE %:keyword%", nativeQuery = true)
    List<UserProfile> findByUserProfileName(String keyword);
}
