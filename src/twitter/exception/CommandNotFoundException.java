package twitter.exception;

public class CommandNotFoundException extends BaseException{
    public CommandNotFoundException(String message) {
        super(message);
    }
}
