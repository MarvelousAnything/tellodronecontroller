package com.drone.drone.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.EnumMap;

@Getter
public enum PortType {
    COMMAND,
    STATE,
    VIDEO;
}
