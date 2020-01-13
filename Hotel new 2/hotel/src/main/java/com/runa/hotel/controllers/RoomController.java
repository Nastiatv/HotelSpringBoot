package com.runa.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runa.hotel.api.dto.RoomDto;
import com.runa.hotel.api.service.IRoomService;
import com.runa.hotel.entities.Room;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

	@Autowired
	IRoomService roomService;

	@GetMapping
	public List<RoomDto> getAllRooms() {
		return roomService.getAllRooms();
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Room addRoom(@RequestBody RoomDto roomDto) {
		return roomService.addRoom(roomDto);
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
		 roomService.updateRoom(id, roomDto);
	}

	@GetMapping(value = "/{id}")
	public Room getRoom(@PathVariable Long id) {
		String test="test";
		roomService.getRoomById(id);
			test.charAt(1);
			return null;
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteRoom(@PathVariable Long id) {
		roomService.getRoomById(id);
	}
}