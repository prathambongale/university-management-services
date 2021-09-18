package edu.university.universityofficeservices.services;

import edu.university.universityofficeservices.dataobjects.CreateUserRequestDTO;
import edu.university.universityofficeservices.dataobjects.GetUserIdRequestDTO;
import edu.university.universityofficeservices.dataobjects.responses.ResponseMessage;
import org.springframework.http.ResponseEntity;;

public interface OfficeLoginService {

    ResponseEntity<ResponseMessage> createUserLogin(CreateUserRequestDTO createUserRequestDTO);
    ResponseEntity<ResponseMessage> getUserId(GetUserIdRequestDTO getUserIdRequestDTO);
}
