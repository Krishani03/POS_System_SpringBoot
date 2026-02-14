package com.ijse.gdse73.controller;

import com.ijse.gdse73.dto.RequestDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/request")
@RestController
public class RequestController {
    @PostMapping
    public String post(@RequestHeader("Authorization") String authorization,
                       @RequestHeader("token") String token){
        return "Hello World! 6 "+authorization +" : Token :" + token;
    }
    @PostMapping("querystring")
    public String getQueryStringParameters(@RequestParam("name") String name,
                                           @RequestParam("address") String address,
                                           @RequestParam("id") String id){
        return "Hello World! 7" + name +" : " + address +" : " +id;
    }
    @PostMapping("path variable/{name}")
    public String getPathVariable(@PathVariable("name") String name){
        return "Hello World! 8 " + name;
    }
    @PostMapping("path variable/{name}/{address}")
    public String getPathVariables(@PathVariable("name") String name,
                                   @PathVariable("address") String address){
        return "Hello World! 8 " + name + " : " + address;
    }
    //request body - form data - not worked
   /* @PostMapping("body/form")
    public String getRequestBodyFormData(@RequestParam("id") String id,
                                         @RequestParam("name")  String name){
        return "Hello World! 9 " + id + " : " + name;
    }*/
    @PostMapping(
            value = "body/form",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String getRequestBodyFormData(@RequestParam("id") String id,
                                         @RequestParam("name") String name) {
        return "Hello World! 9 " + id + " : " + name;
    }

    //request body - xwww from url encoded - done
    @PostMapping("body/form-url-encoded")
    public String getRequestBodyXWWWFormUrlEncoded(@RequestParam("id") String id,
                                                   @RequestParam("name")  String name){
        return "Hello World! 9 " + id + " : " + name;
    }
    //request body - JSON
  /*  @PostMapping("body/json")
    public String getRequestBodyJson(){
        return "Hello World! 9 ";
    }*/
/*
 @PostMapping(path = "saveWithJSON",
 consumes = {MediaType.APPLICATION_JSON_VALUE})
 public String saveRequestWithJSON(@RequestBody RequestDTO requestDTO){
     System.out.println(requestDTO.getId());
     System.out.println(requestDTO.getName());
     return "Hello World! 9 " + requestDTO.getId();
 }
*/
    @PostMapping(
            path = "saveWithJSON",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    "application/json;charset=UTF-8"
            },
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String saveRequestWithJSON(@RequestBody RequestDTO requestDTO){
        return "Hello World! 9 " + requestDTO.getId();
    }


    @RestController
    public static class HomeController {
        @GetMapping("/")
        public String home() {
            return "API is running!";
        }
    }


}