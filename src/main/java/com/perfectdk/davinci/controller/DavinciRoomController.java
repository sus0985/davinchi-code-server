package com.perfectdk.davinci.controller;

import com.perfectdk.davinci.model.DavinciUserType;
import com.perfectdk.davinci.repository.DavinciGameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/room")
public class DavinciRoomController {

    private final DavinciGameRepository gameRepository;

    @GetMapping
    public ResponseEntity<DavinciUserType> enterRoom(@RequestParam String roomNumber) {
        return ResponseEntity.ok().build();
    }
}
