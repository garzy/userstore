/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.tangorabox.userstore.controller;

import com.tangorabox.userstore.model.ErrorDTO;
import com.tangorabox.userstore.model.UserDTO;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-16T02:03:43.863988800+02:00[Europe/Paris]")
@Validated
@Api(value = "Users", description = "the Users API")
public interface UsersApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /users : Create a user
     *
     * @param userDTO  (required)
     * @return Successful request. The user was successfully created. (status code 201)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Create a user", nickname = "createUser", notes = "", response = UserDTO.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Successful request. The user was successfully created.", response = UserDTO.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorDTO.class) })
    @PostMapping(
        value = "/users",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserDTO> createUser(@ApiParam(value = "" ,required=true )  @Valid @RequestBody UserDTO userDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"birthdate\" : \"2000-01-23\", \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /users/{id} : Remove an existing user
     *
     * @param id ID of the user to delete (required)
     * @return Successful request (no content). The user was deleted. (status code 204)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Remove an existing user", nickname = "deleteUser", notes = "", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful request (no content). The user was deleted."),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorDTO.class) })
    @DeleteMapping(
        value = "/users/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> deleteUser(@ApiParam(value = "ID of the user to delete",required=true) @PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /users/{id} : Info for a specific user
     *
     * @param id ID of the user to retrieve (required)
     * @return Expected response to a valid request (status code 200)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Info for a specific user", nickname = "getUsersById", notes = "", response = UserDTO.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Expected response to a valid request", response = UserDTO.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorDTO.class) })
    @GetMapping(
        value = "/users/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<UserDTO> getUsersById(@ApiParam(value = "ID of the user to retrieve",required=true) @PathVariable("id") Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"birthdate\" : \"2000-01-23\", \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /users : List all users
     *
     * @return A list of users. (status code 200)
     */
    @ApiOperation(value = "List all users", nickname = "listUsers", notes = "", response = UserDTO.class, responseContainer = "List", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of users.", response = UserDTO.class, responseContainer = "List") })
    @GetMapping(
        value = "/users",
        produces = { "application/json" }
    )
    default ResponseEntity<List<UserDTO>> listUsers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"birthdate\" : \"2000-01-23\", \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /users/{id} : Updates some info of the user
     *
     * @param id ID of the user to update (required)
     * @param userDTO  (required)
     * @return Successful request (no content. The user has benn successfully modified. (status code 204)
     *         or unexpected error (status code 200)
     */
    @ApiOperation(value = "Updates some info of the user", nickname = "updateUser", notes = "", tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Successful request (no content. The user has benn successfully modified."),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorDTO.class) })
    @PatchMapping(
        value = "/users/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> updateUser(@ApiParam(value = "ID of the user to update",required=true) @PathVariable("id") Long id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}