package errors;

public class InvalidTipoNotificacaoException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Notificação inválida!";
    }
}
