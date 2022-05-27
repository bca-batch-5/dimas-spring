package Api.tugas.service;

import Api.tugas.dto.ResponseData;
import Api.tugas.dto.UserDto;

public interface UserService {
    ResponseData<Object> createUser(UserDto userDto);
    ResponseData<Object> getUser(Integer id);
    ResponseData<Object> updateUser(Integer id, UserDto userDto);
    ResponseData<Object> deleteUser(Integer id);
}
