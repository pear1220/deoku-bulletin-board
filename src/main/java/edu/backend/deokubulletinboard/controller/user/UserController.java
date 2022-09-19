package edu.backend.deokubulletinboard.controller.user;

import edu.backend.deokubulletinboard.common.dto.ResponseDTO;
import edu.backend.deokubulletinboard.common.enums.ResponseCode;
import edu.backend.deokubulletinboard.dto.user.UserDTO;
import edu.backend.deokubulletinboard.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName     : edu.backend.deokubulletinboard.controller
 * fileName        : user
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */
@RestController
@RequestMapping( value = "/api/v1/session" )
@Api( tags = "사용자", consumes = "application/json" )
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping( value = "/list" )
    @ApiOperation(value = "사용자 조회")
    public ResponseDTO<List<UserDTO>> selectUserList(@RequestParam( value = "id" ) String id) {
        return new ResponseDTO<>(ResponseCode.OK, userService.selectUserList(id));
    }
}
