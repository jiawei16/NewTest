package com.example.demo;

import com.example.demo.dao.DiscussPostMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.DiscussPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import com.example.demo.entity.User;
import java.applet.AppletContext;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
 class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;


    @Test
    public void  testSelect(){

        User user =userMapper.selectById(102);
        System.out.println(user);

        User user1 =userMapper.selectByName("guanyu");
        System.out.println(user1);

        User user2 =userMapper.selectByEmail("nowcoder102@sina.com");
        System.out.println(user2);
    }
    @Test
    public void testInsert(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("123345");
        user.setSalt("dec");
        user.setEmail("test@163.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());

    }
    @Test
    public  void testUpdate(){
        int rows=userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows= userMapper.updatePassword(150,"68792");
        System.out.println(rows);
        rows=userMapper.updateHeader(150,"http://www.nowcoder.com/121.png");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list=discussPostMapper.selectDiscussPosts(0,0,10);

        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }
        int rows=discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }
}
