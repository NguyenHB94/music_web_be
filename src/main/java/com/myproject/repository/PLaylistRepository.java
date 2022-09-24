package com.myproject.repository;

import com.myproject.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PLaylistRepository extends JpaRepository<Playlist, Long> {
}
