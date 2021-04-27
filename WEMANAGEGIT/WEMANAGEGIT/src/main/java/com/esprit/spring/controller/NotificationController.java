package com.esprit.spring.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value = "NotificationController") // Name of the bean in Spring IoC

public class NotificationController {

}
