package edu.backend.deokubulletinboard.service.user;

import edu.backend.deokubulletinboard.dto.user.UserDTO;
import edu.backend.deokubulletinboard.mapper.user.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName     : edu.backend.deokubulletinboard.service
 * fileName        : UserService
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */
@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> selectUserList(String id) {
        return userMapper.selectUserList(id);
    }
}
