package com.example.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mbs.entity.Room;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findByRoomno(int roomno);


    // JPQL Query to get rooms by category
    @Query("SELECT r FROM Room r WHERE r.category = ?1")
    List<Room> findByCategory(String category);

    // Pagination and Sorting
    @SuppressWarnings("null")
    Page<Room> findAll(Pageable pageable);
}
