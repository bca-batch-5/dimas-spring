package Api.tugas.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Api.tugas.dto.ResponseData;
import Api.tugas.dto.UserDto;
import Api.tugas.model.User;
import Api.tugas.repository.UserRepo;
import Api.tugas.service.UserService;
import Api.tugas.validator.UserValidation;

@Service
@Transactional
public class UserImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserValidation userValidation;

    ResponseData<Object> responseData;

    @Override
    public ResponseData<Object> createUser(UserDto userDto) {
        User user = new User(userDto.getUsername(), userDto.getPassword());
        userRepo.save(user);
        responseData = new ResponseData<Object>(HttpStatus.CREATED.value(),"Success", user);
        return responseData;
        
    }

    @Override
    public ResponseData<Object> getUser(Integer id) {
        responseData = userValidation.getUserValidation(id);
        return responseData;
    }

    @Override
    public ResponseData<Object> updateUser(Integer id, UserDto userDto) {
        responseData = userValidation.updateUserValidation(id, userDto);
        return responseData;
    }

    @Override
    public ResponseData<Object> deleteUser(Integer id) {
        responseData = userValidation.deleteUserValidation(id);
        return responseData;
    }
    
}
