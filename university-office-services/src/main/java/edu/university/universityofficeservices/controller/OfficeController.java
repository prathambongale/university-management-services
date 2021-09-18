package edu.university.universityofficeservices.controller;

import edu.university.universityofficeservices.dataobjects.CreateUserRequestDTO;
import edu.university.universityofficeservices.dataobjects.GetUserIdRequestDTO;
import edu.university.universityofficeservices.dataobjects.responses.ResponseMessage;
import edu.university.universityofficeservices.services.OfficeLoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/office", produces = MediaType.APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeLoginService officeLoginService;

    @Autowired
    public OfficeController(OfficeLoginService officeLoginService) {
        this.officeLoginService = officeLoginService;
    }

    @PostMapping("/createUserLogin")
    @ApiOperation(value = "", tags = "Login Management")
    public ResponseEntity<ResponseMessage> createUserLogin(@Valid @RequestBody CreateUserRequestDTO createUserRequestDTO) {
        return officeLoginService.createUserLogin(createUserRequestDTO);
    }

    @PostMapping("/getUserId")
    @ApiOperation(value = "", tags = "Login Management")
    public ResponseEntity<ResponseMessage> getUserId(@Valid @RequestBody GetUserIdRequestDTO getUserIdRequestDTO) {
        return officeLoginService.getUserId(getUserIdRequestDTO);
    }

}
