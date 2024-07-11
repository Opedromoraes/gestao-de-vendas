package com.example.gestaodevendas.domain.exceptions.handler;

import com.example.gestaodevendas.domain.exceptions.BaseException;
import com.example.gestaodevendas.domain.exceptions.BusinessException;
import com.example.gestaodevendas.domain.exceptions.DataBaseException;
import com.example.gestaodevendas.domain.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<String> handleDatabaseException(DataBaseException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<String> handleBaseException(BaseException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleBaseException(Exception ex) {
        return new ResponseEntity<>(ex.getCause().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    private final MessageUtils messageUtils;
//
//    @ExceptionHandler({
//            BusinessException.class,
//            NotFoundException.class
//    })
//    public ResponseEntity<ErroDTO> handleBusinessException(BaseException e) {
//
//        List<String> errors = new ArrayList<>();
//        if (e.getErrors() != null && !e.getErrors().isEmpty()) {
//            errors.addAll(e.getErrors().stream()
//                    .map(messageUtils::getMessage)
//                    .toList());
//        }
//
//        ErroDTO errorDTO = ErroDTO.builder()
//                .message(messageUtils.getMessage(e.getMessage()))
//                .errors(errors)
//                .build();
//
//        return ResponseEntity.status(e.getStatus()).body(errorDTO);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatusCode statusCode,
//                                                                  WebRequest request) {
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(objectError -> messageUtils.getMessage("field.required", objectError.getField()))
//                .toList();
//
//        ErroDTO errorDTO = ErroDTO.builder()
//                .message(messageUtils.getMessage("base.message.error"))
//                .errors(errors)
//                .build();
//
//
//        return ResponseEntity.status(ex.getStatusCode()).body(errorDTO);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatusCode status,
//                                                                  WebRequest request) {
//        ErroDTO errorDTO = ErroDTO.builder()
//                .message("Request body is not readable")
//                .build();
//
//        return ResponseEntity.status(status).headers(headers).body(errorDTO);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
//                                                                     HttpHeaders headers,
//                                                                     HttpStatusCode status, WebRequest request) {
//        List<String> supportedMediaTypes = ex.getSupportedMediaTypes()
//                .stream()
//                .map(MediaType::toString)
//                .toList();
//
//        ErroDTO errorDTO = ErroDTO.builder()
//                .message("Supported media types: " + String.join(", ", supportedMediaTypes))
//                .build();
//
//        return ResponseEntity.status(status).headers(headers).body(errorDTO);
//    }
//
//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<Object> handleException(Exception ex) {
//
//        log.error("Unexpected error", ex);
//
//        ErroDTO errorDTO = ErroDTO.builder()
//                .message(messageUtils.getMessage("base.message.error-unexpected"))
//                .errors(null)
//                .build();
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
//
//    }
}

