package com.sparta.scheduler.controller;

import com.sparta.scheduler.dto.*;
import com.sparta.scheduler.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    // 일정 생성 POST
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(request));
    }
    // 선택 일정 조회 GET
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetSchduleResponse> getOneSchedule(@PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }
    // 전체 일정 조회 GET
    @GetMapping("/schedules")
    public ResponseEntity<List<GetSchduleResponse>> getAllSchedules() {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll());
    }
    // 선택한 일정 부분 수정 PATCH
    @PatchMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> updateScheduleContents(
        @PathVariable Long scheduleId,
        @RequestBody UpdateScheduleRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(scheduleId, request));
    }
    // 선택한 일정 삭제 DELETE
    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
