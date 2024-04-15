package com.example.restobar.controllers;

import com.example.restobar.models.Mesa;
//import com.example.restobar.services.MesaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "/mesas")
public class MesaController /*extends BaseControllerImpl<Mesa, MesaServiceImpl>*/{
}
