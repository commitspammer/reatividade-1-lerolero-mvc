package com.trivia247.gateway.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;

import com.trivia247.gateway.models.dto.LobbyDTO;
import com.trivia247.gateway.models.dto.NewLobbyDTO;

@Service
public class LobbyService {

	private RestTemplate restTemplate = new RestTemplate();
	
	private String baseURL = "http://localhost:8082";

	public LobbyDTO openLobby(NewLobbyDTO newLobbyDTO) {
		String url = baseURL + "/lobbies";
		HttpEntity<NewLobbyDTO> req = new HttpEntity<>(newLobbyDTO);
		try {
			LobbyDTO lobbyDTO = restTemplate.postForObject(url, req, LobbyDTO.class);
			return lobbyDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<LobbyDTO> findLobbies() {
		String url = baseURL + "/lobbies";
		try {
			ResponseEntity<LobbyDTO[]> resp = restTemplate.getForEntity(url, LobbyDTO[].class);
			return Arrays.asList(resp.getBody());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public LobbyDTO closeLobby(String lobbyId, String ownerUID) {
		String url = baseURL + "/lobbies/" + lobbyId + "?ownerUID=" + ownerUID;
		try {
			ResponseEntity<LobbyDTO> resp = restTemplate.exchange(
					url,
					HttpMethod.DELETE,
					HttpEntity.EMPTY,
					LobbyDTO.class
			);
			return resp.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//public String retrieveNickname(String token) {
	//	String url = baseURL + "/lobbies/" + token;
	//	try {
	//		NicknameDTO nicknameDTO = restTemplate.getForObject(url, NicknameDTO.class);
	//		return nicknameDTO.nickname();
	//	} catch (Exception e) {
	//		e.printStackTrace();
	//		return null;
	//	}
	//}

}
