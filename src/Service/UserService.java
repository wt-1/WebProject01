package Service;

import empty.User;

public interface UserService {
    /**
     * 增加
     *
     * @param pro
     * @return
     */
    int AddUser(User pro);
    /**
     * 登录
     * @param user
     * @return
     */
    User UserLogin(User user);
    /**
     * 自动生成百以内的加减乘除
     */

}

