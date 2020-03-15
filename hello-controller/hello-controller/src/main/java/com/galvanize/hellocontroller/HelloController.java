package com.galvanize.hellocontroller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

 //   @RequestMapping(value = "/api", method = RequestMethod.GET)
    @GetMapping
    public String sayHello(@RequestParam(required=false, defauld="world") String name) {
        return String.format("Hello %s from my sayHello", name);
    }

     @GetMapping("/{name}")
    public string sayHelloPath(@PathVariable(required = false) String name){
        return String.format("Hello %s, from sayHelloPath", name == null  "world" : name);
     }

     @PostMapping
    public String sayHelloPost(@RequestBody String name){
        return String.format("Hello %s, from sayHelloPost", name);
     }
}
