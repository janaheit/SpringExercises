package be.abis.exercise.advice;

import be.abis.exercise.error.ApiError;
import be.abis.exercise.exceptions.CourseAlreadyExistsException;
import be.abis.exercise.exceptions.CourseNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CourseResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CourseNotFoundException.class)
    public ResponseEntity<? extends Object> handleCourseNotFoundException(CourseNotFoundException ex,
                                                                          WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiError apiError = new ApiError("course not found", status.value(), ex.getMessage());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);

        return new ResponseEntity<ApiError>(apiError, responseHeaders, status);
    }

    @ExceptionHandler(value = CourseAlreadyExistsException.class)
    public ResponseEntity<? extends Object> handleCourseAlreadyExistsException(CourseAlreadyExistsException ex,
                                                                          WebRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        ApiError apiError = new ApiError("course already exists", status.value(), ex.getMessage());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);

        return new ResponseEntity<ApiError>(apiError, responseHeaders, status);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    protected ResponseEntity<ApiError> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
                                                                                 WebRequest request){
        ApiError ae = new ApiError("type conversion failed", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<ApiError>(ae, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<ApiError> handleConstraintViolationException(ConstraintViolationException ex,
                                                                                 WebRequest request){
        HttpStatus status =  HttpStatus.BAD_REQUEST;
        ApiError ae = new ApiError("argument not valid", status.value(), ex.getMessage());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("content-type", MediaType.APPLICATION_PROBLEM_JSON_VALUE);
        return new ResponseEntity<ApiError>(ae, responseHeaders, status);
    }
}
