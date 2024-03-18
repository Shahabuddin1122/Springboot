package com.dsi.database.repository;

import com.dsi.database.model.AppUser;
import com.dsi.database.projection.AppUserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUserView getByEmail(String email);

    AppUser findByEmail(String email);

    List<AppUser> findAllByRole(String role);
}
