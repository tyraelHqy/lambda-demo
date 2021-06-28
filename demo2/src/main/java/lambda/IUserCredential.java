package lambda;

/**
 * 用户身份认证标记接口
 */
@FunctionalInterface
public interface IUserCredential {
    /**
     * 通过用户账号，验证用户身份信息的接口
     * @param username 要验证的用户账号
     * @return 返回身份信息[系统管理员，用户管理员，普通用户]
     */
    String verifyUser(String username);

    default String getCredential(String username){
        // 模拟方法
        if("admin".equals(username)){
            return "admin + 系统管理员";
        }else if("manager".equals(username)){
            return "manager + 用户管理员";
        }else {
            return "commons + 普通会员";
        }
    }

}
