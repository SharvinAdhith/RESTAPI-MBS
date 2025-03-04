package com.example.mbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.mbs.entity.Room;
import com.example.mbs.exception.ResourceNotFoundException;
import com.example.mbs.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(int id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + id));
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(int id, Room room) {
        room.setId(id);
        return roomRepository.save(room);
    }

    public String deleteRoom(int id) {
        roomRepository.deleteById(id);
        return "Successfully deleted the room details";
    }

    public Page<Room> getRoomsByPage(int page, int size){
        Pageable pageable=PageRequest.of(page, size);
        return roomRepository.findAll(pageable);
    }

    public List<Room> getRoomsByCategory(String category) {
        return roomRepository.findByCategory(category);
    }
    public List<Room> sortByRoom(){
        return roomRepository.findAll(Sort.by("roomno").ascending());
    }
}
