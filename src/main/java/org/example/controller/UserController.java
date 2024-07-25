package org.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author elcnu
 * @since 2024-07-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户列表分页查询
     *
     * @param current 当前页数
     * @param size 每页条数
     * @return ResponseEntity<Page<User>>
     */
    @GetMapping("/page")
    public ResponseEntity<Page<User>> userPageQuery(@RequestParam("current") Integer current,
                                                    @RequestParam("size") Integer size) {
        Page<User> pageParam = new Page<>(current, size);
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.select(User::getId, User::getCreateTime, User::getCreateTime)
                .ge(User::getCreateTime, "2023-11-12");
        Page<User> pageResult = userService.page(pageParam, queryWrapper);
        return ResponseEntity.ok(pageResult);
    }

}
