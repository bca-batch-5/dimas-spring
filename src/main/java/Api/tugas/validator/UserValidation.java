package Api.tugas.validator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import Api.tugas.Exception.DataNotFoundException;
import Api.tugas.dto.ResponseData;
import Api.tugas.dto.UserDto;
import Api.tugas.model.User;
import Api.tugas.repository.UserRepo;

@Service
public class UserValidation {
    @Autowired
    UserRepo userRepo;
    ResponseData<Object> responseData;

    public ResponseData<Object> getUserValidation(Integer id){
        if (id == null) {
            List<User> users = userRepo.findAll();
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "Success", users);
            return responseData;
        } else {
            Optional<User> userOpt = userRepo.findById(id);
            if (userOpt != null) {
                User user = userOpt.get();
                responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "succes", user);
                return responseData;
            } else {
                throw new DataNotFoundException("data tidak ditemukan");
            }
            
        }
    } 

    public ResponseData<Object> updateUserValidation(Integer id, UserDto userDto){
        Optional<User> userOpt = userRepo.findById(id);
        if (userOpt != null) {
            User user = userOpt.get();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            userRepo.save(user);
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "succes", user);
            return responseData;
        } else {
            throw new DataNotFoundException("data tidak ditemukan");
        }
    }

    public ResponseData<Object> deleteUserValidation(Integer id){
        Optional<User> userOpt = userRepo.findById(id);
        if (userOpt != null) {
            User user = userOpt.get();
            user.setIsDeleted(true);
            userRepo.save(user);
            responseData = new ResponseData<Object>(HttpStatus.FOUND.value(), "data berhasil dihapus", null
            );
            return responseData;
        } else {
            throw new DataNotFoundException("data tidak ditemukan");
        }
    }
}
