package com.zoytech.winwine.webapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {

  @GetMapping("/ping")
  public String getPing() {
    return "pong";
  }

  @PostMapping("/ping")
  public String postPing() {
    return "pong";
  }


}
