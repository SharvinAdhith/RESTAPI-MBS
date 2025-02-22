package com.example.mbs.controller;

import com.example.mbs.entity.Room;
import com.example.mbs.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable int id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        return ResponseEntity.ok(roomService.saveRoom(room));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable int id, @RequestBody Room room) {
        return ResponseEntity.ok(roomService.updateRoom(id, room));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable int id) {
        return ResponseEntity.ok(roomService.deleteRoom(id));
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Room>> getRoomsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "category") String sortBy) {
        return ResponseEntity.ok(roomService.getRoomsByPage(page, size, sortBy));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Room>> getRoomsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(roomService.getRoomsByCategory(category));
    }
}
