package lambda.impl;

import lambda.IMessageFormat;

public class MessageFormateImpl implements IMessageFormat {
    @Override
    public String format(String message, String format) {
        System.out.println("消息转换");
        return message;
    }
}
