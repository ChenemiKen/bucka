package com.chenemiken.bucka.controller;

import com.chenemiken.bucka.entity.User;
import com.chenemiken.bucka.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="Authentication Endpoints")
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  UserService userService;

  @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "SignUp", description = "Create a new user")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Successful creation of contact"),
          @ApiResponse(responseCode = "400", description = "Bad request: unsuccessful submission", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
  })
  public ResponseEntity<Map<String, Object>> signUp(@RequestBody @Valid User user){
    user = userService.saveUser(user);
    Map<String, Object> userMap = new HashMap<>(Map.ofEntries(
        Map.entry("id",user.getId()),
        Map.entry("username", user.getUsername()),
        Map.entry("email", user.getEmail())
    ));
    return new ResponseEntity<>(userMap, HttpStatus.CREATED);
  }

  @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Fetch users", description = "Returns a List of all active users")
  @ApiResponse(responseCode = "200", description = "Successful retrieval of users", content = @Content(array = @ArraySchema(schema = @Schema(implementation = User.class))))
  public ResponseEntity<List<User>> allUsers(){
//    return new ResponseEntity<>(users, HttpStatus.OK);
    return null;
  }
}