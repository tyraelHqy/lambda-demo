package lambda;

@FunctionalInterface
public interface IMessageFormat {

    /**
     * 消息转换方法
     * @param message 要转换的消息
     * @param format 转换的格式[xml/json...]
     * @return 返回转换后的数据
     */
    String format(String message,String format);

    /**
     * 消息合法性验证方法
     * @param message
     * @return
     */
    static boolean verifyMessage(String message){
        if(message != null){
            return true;
        }else {
            return false;
        }
    }
}
