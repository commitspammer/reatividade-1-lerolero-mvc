package com.trivia247.gateway.models.dto;

public record NewLobbyDTO(
		String name,
		String ownerName,
		String ownerUID,
		Integer sizeLimit
) {}
