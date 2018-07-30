package com.liuyanzhao.cloud.web.controller;

import com.liuyanzhao.cloud.api.model.User;
import com.liuyanzhao.cloud.api.service.UserService;
import com.liuyanzhao.cloud.web.enums.StatusCodeEnum;
import com.liuyanzhao.cloud.web.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 言曌
 * @date 2018/7/29 下午10:50
 */

@RestController
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<ResultVO> userList() {
        List<User> userList = userService.listUsers();
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(), userList));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ResultVO> userList(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(), user));
    }


    @PostMapping("/user")
    public ResponseEntity<ResultVO> insertUser(@RequestBody User user) {
        User result = null;
        try {
           result = userService.insertUser(user);
        } catch (Exception e) {
            return ResponseEntity.status(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode()).body(new ResultVO(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode(), StatusCodeEnum.DEFAULT_FAIL_CODE.getMessage()));
        }
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(),result));
    }

    @PutMapping("/user")
    public ResponseEntity<ResultVO> updateUser(@RequestBody User user) {
        try {
            if(user != null && user.getId() != null) {
                userService.updateUser(user);
            } else {
                return ResponseEntity.status(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode()).body(new ResultVO(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode(), StatusCodeEnum.DEFAULT_FAIL_CODE.getMessage()));
            }
        } catch (Exception e) {
            return ResponseEntity.status(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode()).body(new ResultVO(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode(), StatusCodeEnum.DEFAULT_FAIL_CODE.getMessage()));
        }
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(), user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ResultVO> deleteUser(@PathVariable("id") Integer id) {
        try {
            userService.deleteUserById(id);
        } catch (Exception e) {
            return ResponseEntity.status(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode()).body(new ResultVO(StatusCodeEnum.DEFAULT_FAIL_CODE.getCode(), StatusCodeEnum.DEFAULT_FAIL_CODE.getMessage()));
        }
        return ResponseEntity.ok().body(new ResultVO(StatusCodeEnum.SUCCESS_CODE.getCode(), StatusCodeEnum.SUCCESS_CODE.getMessage(),id));
    }


}
