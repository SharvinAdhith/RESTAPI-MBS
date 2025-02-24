package com.example.mbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mbs.entity.Room;
import com.example.mbs.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/getrooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @PostMapping("/postrooms")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        return ResponseEntity.ok(roomService.saveRoom(room));
    }

    @PutMapping("/updaterooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable int id, @RequestBody Room room) {
        return ResponseEntity.ok(roomService.updateRoom(id, room));
    }

    @DeleteMapping("/deleterooms/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable int id) {
        return ResponseEntity.ok(roomService.deleteRoom(id));
    }

    @GetMapping("/getrooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable int id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @GetMapping("/pagerooms")
     public Page<Room> getRoomsByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
      return roomService.getRoomsByPage(page, size);
    }

    @GetMapping("/getcategory/{category}")
    public ResponseEntity<List<Room>> getRoomsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(roomService.getRoomsByCategory(category));
    }

    @GetMapping("/roomsorting")
    public List<Room> sortByRoom(){
        return roomService.sortByRoom();
    }
}
