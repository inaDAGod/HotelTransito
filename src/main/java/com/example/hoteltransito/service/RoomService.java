package com.example.hoteltransito.service;
import com.example.hoteltransito.model.Room;
import com.example.hoteltransito.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    @Transactional
    public Room create(Room room) {
        return roomRepository.save(room);
    }

    @Transactional
    public Optional<Room> update(Long id, Room room) {
        return roomRepository.findById(id)
                .map(existing -> {
                    existing.setRoomNumber(room.getRoomNumber());
                    existing.setRoomType(room.getRoomType());
                    existing.setFloor(room.getFloor());
                    existing.setStatus(room.getStatus());
                    existing.setCreatedAt(room.getCreatedAt());
                    return roomRepository.save(existing);
                });
    }

    @Transactional
    public boolean delete(Long id) {
        return roomRepository.findById(id)
                .map(existing -> {
                    roomRepository.delete(existing);
                    return true;
                }).orElse(false);
    }
}
