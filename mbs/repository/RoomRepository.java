package com.example.mbs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mbs.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Optional<Room> findByRoomno(int roomno);


    @Query("SELECT r FROM Room r WHERE r.category = ?1")
    List<Room> findByCategory(String category);

}
