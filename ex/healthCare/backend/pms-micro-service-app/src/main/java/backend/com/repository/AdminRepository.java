package backend.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import backend.com.entity.Login;

@Repository
public interface AdminRepository extends JpaRepository<Login, String>{
	
	@Query("select l from Login l where l.email = :email and l.password = :password")
	public Login checkAdminLogin(@Param("email") String email, @Param("password") String password);
}