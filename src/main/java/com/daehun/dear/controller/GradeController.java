package com.daehun.dear.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class GradeController {

}
