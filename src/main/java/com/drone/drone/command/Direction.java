package com.drone.drone.command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Direction {
    LEFT("l"),
    RIGHT("r"),
    FORWARD("f"),
    BACK("b");

    private final String code;
}
