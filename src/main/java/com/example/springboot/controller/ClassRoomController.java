package com.example.springboot.controller;

import com.example.springboot.request.ClassRoomRequest;
import com.example.springboot.service.ClassRoomService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classRoom")
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;

    @PostMapping("/post")
    public ResponseEntity<?> postClassRoom(@RequestBody ClassRoomRequest classRequest){
        try {
            classRoomService.saveClassRoom(classRequest);
            return new ResponseEntity<>("New ClassRoom Successes", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("New ClassRoom Fail", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("get")
    public ResponseEntity<? extends Object> getClassRoom(){
        try {
            return new ResponseEntity<>(classRoomService.getAllClassRoom(), HttpStatus.OK);
        }catch (Exception e){
            System.out.print(e);
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteClassRoom(@RequestBody ClassRoomRequest classRoomRequest){
        try {
            classRoomService.deleteClassRoom(classRoomRequest);
            return new ResponseEntity<>("Delete ClassRoom Successes", HttpStatus.OK);
        }catch (Exception e){
            System.out.print(e);
            return new ResponseEntity<>("Delete ClassRoom Fail", HttpStatus.CONFLICT);
        }
    }
}
