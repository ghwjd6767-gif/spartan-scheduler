package com.sparta.scheduler.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest {
    // 일정이 저장할 정보들
    private String name;
    private String password;
    private String title;
    private String contents;

}
