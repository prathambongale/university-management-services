package edu.university.universityofficeservices.services.impl;

import edu.university.universityofficeservices.dataobjects.CreateUserRequestDTO;
import edu.university.universityofficeservices.dataobjects.CreateUserResponseDTO;
import edu.university.universityofficeservices.dataobjects.GetUserIdRequestDTO;
import edu.university.universityofficeservices.dataobjects.responses.ResponseMessage;
import edu.university.universityofficeservices.models.OfficeLogin;
import edu.university.universityofficeservices.repository.OfficeLoginRepository;
import edu.university.universityofficeservices.services.OfficeLoginService;
import edu.university.universityofficeservices.util.OfficeResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@Slf4j
public class OfficeLoginServiceImpl extends OfficeResponses implements OfficeLoginService {

    private final OfficeLoginRepository officeLoginRepository;

    @Autowired
    public OfficeLoginServiceImpl(OfficeLoginRepository officeLoginRepository) {
        this.officeLoginRepository = officeLoginRepository;
    }

    @Override
    public ResponseEntity<ResponseMessage> createUserLogin(CreateUserRequestDTO createUserRequestDTO) {
        var officeLogin = new OfficeLogin();
        var createUserResponseDTO = new CreateUserResponseDTO();
        var date = String.valueOf(LocalDateTime.now().getYear()) +
                LocalDateTime.now().getMonthValue() +
                LocalDateTime.now().getDayOfMonth();

        Random random = new Random();
        var randomNumber = random.nextInt(5000);
        var userId =  createUserRequestDTO.getUsername().substring(0,3) + date + randomNumber;
        officeLogin.setUserId(userId);
        officeLogin.setEmail(createUserRequestDTO.getEmail());
        officeLogin.setCell(createUserRequestDTO.getCell());
        officeLogin.setUsername(createUserRequestDTO.getUsername());
        officeLogin.setPassword(createUserRequestDTO.getPassword());
        officeLoginRepository.save(officeLogin);
        createUserResponseDTO.setUserId(userId);
        return buildSuccessCreateResponse(createUserResponseDTO);
    }

    @Override
    public ResponseEntity<ResponseMessage> getUserId(GetUserIdRequestDTO getUserIdRequestDTO) {
        try {
            var createUserResponseDTO = new CreateUserResponseDTO();
            var userId = officeLoginRepository
                    .findByEmailAndCell(getUserIdRequestDTO.getEmail(), getUserIdRequestDTO.getCell());
            createUserResponseDTO.setUserId(userId);
            return buildSuccessCreateResponse(createUserResponseDTO);
        } catch (Exception exc) {
            return buildExceptionResponse(exc);
        }

    }
}
