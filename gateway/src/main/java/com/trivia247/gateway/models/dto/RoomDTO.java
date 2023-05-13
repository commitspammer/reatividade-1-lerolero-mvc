package com.trivia247.gateway.models.dto;

import java.util.List;

public record RoomDTO(
		String uid,
		String name,
		Integer sizeLimit,
		List<String> participantNames
) {}
