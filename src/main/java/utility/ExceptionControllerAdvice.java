package utility;

import exception.InfyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
    public class ExceptionControllerAdvice {
        @Autowired
        Environment environment;
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
            ErrorInfo error = new ErrorInfo();
            error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
            error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            error.setTimestamp(LocalDateTime.now());
            return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        @ExceptionHandler(InfyException.class)
        public ResponseEntity<ErrorInfo> infyExceptionHandler(InfyException exception) {
            ErrorInfo error = new ErrorInfo();
            error.setErrorMessage(environment.getProperty(exception.getMessage()));
            error.setTimestamp(LocalDateTime.now());
            error.setErrorCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
        }

//        @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
//    public ResponseEntity<ErrorInfo> validatorExceptionHandler(Exception exception)
//    {
//        LOGGER.error(exception.getMessage(), exception);
//        String errorMsg;
//        if (exception instanceof MethodArgumentNotValidException)
//        {
//            MethodArgumentNotValidException manvException = (MethodArgumentNotValidException) exception;
//            errorMsg = manvException.getBindingResult()
//                    .getAllErrors()
//                    .stream()
//                    .map(ObjectError::getDefaultMessage)
//                    .collect(Collectors.joining(", "));
//
//        }
//        else
//        {
//            ConstraintViolationException cvException = (ConstraintViolationException) exception;
//            errorMsg = cvException.getConstraintViolations()
//                    .stream()
//                    .map(ConstraintViolation::getMessage)
//                    .collect(Collectors.joining(", "));
//
//        }
//        ErrorInfo errorInfo = new ErrorInfo();
//        errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
//        errorInfo.setErrorMessage(errorMsg);
//        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
//    }
//}


    }


