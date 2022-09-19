package edu.backend.deokubulletinboard.mapper.user;

import edu.backend.deokubulletinboard.dto.user.UserDTO;

import java.util.List;

/**
 * packageName     : edu.backend.deokubulletinboard.mapper.user
 * fileName        : UserMapper
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */
public interface UserMapper {
    List<UserDTO> selectUserList(String id);
}
