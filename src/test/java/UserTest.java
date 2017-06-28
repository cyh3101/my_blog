import com.cyh.blog.entity.User;
import com.cyh.blog.service.impl.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by cyh3101 on 2017/6/17.
 */
public class UserTest extends  BaseTest{
    @Autowired
    private UserService userService;


    public void testUserMapper(){
        Set<String> roleStrs = this.userService.getRolesByUserName("test01");
        if(!roleStrs.isEmpty()){
            System.out.println("roles: ");
            for (String roleStr : roleStrs
                 ) {
                System.out.println(roleStr);
            }
        }

    }


    public void testGetPermissionsByRole(){
        Set<String> perStrs = this.userService.getPermissionsByRole("normal_user");
        if(!perStrs.isEmpty()){
            System.out.println("permissions: ");
            for (String perStr:perStrs
                 ) {
                System.out.println(perStr);
            }
        }
    }


    public void testGetPermissionsByUserName() {
        Set<String> permissions = this.userService.getPermissionsByUserName("test01");
        if (!permissions.isEmpty()) {
            System.out.println("permissions: ");
            for (String permission : permissions
                    ) {
                System.out.println(permission);
            }
        }
    }

    @Test
    public void testGiveRole(){
        User user = new User();
        user = userService.getUserById(1);
        System.out.println(this.userService.getRolesByUserName(user.getUsername()));
        this.userService.giveRole(user , 3);
        System.out.println(this.userService.getRolesByUserName(user.getUsername()));
    }

    @Test
    public void testGetUserList(){
        List<User> userList = this.userService.getUserList();
        for (int i = 0 ; i < userList.size() ; i++){
            System.out.println(userList.get(i));
        }
    }
}
