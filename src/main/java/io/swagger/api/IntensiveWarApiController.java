package io.swagger.api;

import io.swagger.Repository.UserRepository;
import io.swagger.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-31T19:25:47.602Z")

@Controller
public class IntensiveWarApiController implements IntensiveWarApi {

    private static final Logger log = LoggerFactory.getLogger(IntensiveWarApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public IntensiveWarApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteUserUsingDELETE(@ApiParam(value = "id",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        userRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getAllUsersUsingGET() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<User> getOneUserUsingGET(@ApiParam(value = "id",required=true) @PathVariable("id") Long id) {
        User user = userRepository.findOne(id);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> insertUserUsingPOST(@ApiParam(value = "user" ,required=true )  @Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<User> insertUserUsingPUT(
                        @ApiParam(value = "user" ,required=true )  @Valid @RequestBody User user,
                        @ApiParam(value = "id",required=true) @PathVariable("id") Long id) {
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

}
