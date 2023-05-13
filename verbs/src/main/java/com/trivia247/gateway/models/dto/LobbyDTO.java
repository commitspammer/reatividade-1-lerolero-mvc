package com.trivia247.gateway.models.dto;

import java.util.List;

public record LobbyDTO(
		String lobbyUID,
		String name,
		Integer sizeLimit,
		List<String> participantNames
) {}
