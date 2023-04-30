package com.gihanz.controller;

import com.gihanz.dtos.StudentDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("students")
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static List<StudentDTO> list = new ArrayList<>();

    @GetMapping(value = "greting")
    public String printMsg(){
        return "HI Pumika I'm Spring boot";
    }

    @PostMapping()
    public StudentDTO create(@RequestBody StudentDTO dto){
        dto.setId(list.size()+1l);
        list.add(dto);
        return dto;
    }

    @PutMapping()
    public StudentDTO update(@RequestBody StudentDTO dto){
        list.removeIf(d ->d.equals(dto) );
        return dto;
    }

    @GetMapping()
    public List< StudentDTO> findAll(){
        return list;
    }

    @GetMapping(value = "/{id}")
    public  StudentDTO findAll(@PathVariable("id") Long id){
        return list.stream().filter(dto -> dto.getId().equals(id)).findAny().get();
    }
}

