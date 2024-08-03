package relucky.code.testapi.exception;

/**
 * @author yernuromirzak
 * 03.08.2024
 */
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
