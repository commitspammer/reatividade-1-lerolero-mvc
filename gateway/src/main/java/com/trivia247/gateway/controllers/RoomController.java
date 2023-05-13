package com.trivia247.gateway.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.trivia247.gateway.services.NicknameService;
import com.trivia247.gateway.services.LobbyService;
import com.trivia247.gateway.models.dto.RoomDTO;
import com.trivia247.gateway.models.dto.NewRoomDTO;
import com.trivia247.gateway.models.dto.LobbyDTO;
import com.trivia247.gateway.models.dto.NewLobbyDTO;

@RestController
@RequestMapping("/rooms")
public class RoomController {

	@Autowired
	private LobbyService lobbyService;

	@PostMapping
	public RoomDTO post(@RequestBody NewRoomDTO newRoomDTO) { //might fail parsing body!
		NewLobbyDTO newLobbyDTO = new NewLobbyDTO(
			newRoomDTO.name(),
			"placeholdernickname", //nickname retrieved from token
			"62ac9083-8ec2-40ca-8785-cd34641f9da7", //token from request header
			newRoomDTO.sizeLimit()
		); //TODO both placeholder values should be fetched from some BEAN!
		LobbyDTO lobbyDTO = lobbyService.openLobby(newLobbyDTO);
		if (lobbyDTO == null)
			throw new RuntimeException("failed opening lobby");
		return new RoomDTO(
				lobbyDTO.lobbyUID(),
				lobbyDTO.name(),
				lobbyDTO.sizeLimit(),
				lobbyDTO.participantNames()
		);
	}

	@GetMapping
	public List<RoomDTO> getAll() {
		List<LobbyDTO> lobbyDTOs = lobbyService.findLobbies();
		return lobbyDTOs.stream()
			.map(l -> new RoomDTO(
				l.lobbyUID(),
				l.name(),
				l.sizeLimit(),
				l.participantNames()
			))
			.collect(Collectors.toList());
	}

	@DeleteMapping("/{roomUID}")
	public RoomDTO delete(@PathVariable String roomUID) {
		LobbyDTO lobbyDTO = lobbyService.closeLobby(roomUID, "62ac9083-8ec2-40ca-8785-cd34641f9da7" /*token from header request*/);
		if (lobbyDTO == null)
			throw new RuntimeException("failed closing lobby");
		return new RoomDTO(
				lobbyDTO.lobbyUID(),
				lobbyDTO.name(),
				lobbyDTO.sizeLimit(),
				lobbyDTO.participantNames()
		);
	}

}
