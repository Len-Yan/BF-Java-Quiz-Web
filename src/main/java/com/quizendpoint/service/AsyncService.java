package com.quizendpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizendpoint.domain.Question;
import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;
import com.quizendpoint.response.User_QuestionResponse;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    private QuestionService questionService;
    private UserService userService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //return Question instead of quiz
    public Object getAllInfoAsync(int id) throws IdNotFoundException{
        CompletableFuture<Question> questionFuture = questionService.getQuestionInfoAsync(id);
        CompletableFuture<User> userFuture = userService.getUserInfoAsync(id);
        // CompletableFuture<User> userFuture = userService.getUserInfoAsync();
        // CompletableFuture<User> quizFuture = quizService.getQuizInfoAsync();

        CompletableFuture<Object> responseFuture = CompletableFuture.allOf(
                userFuture, questionFuture
        ).thenApply((placeHolder) -> {
            //return questionFuture.join() + " "  + userFuture.join();


            User_QuestionResponse uq = User_QuestionResponse.builder()
            		.user(userFuture.join()).question(questionFuture.join()).build();
            return uq;
            // CombinedResult.builder
            //  .user(user)
            //  .quiz(quiz)
            //  .build()
        });

        return responseFuture.join();
    }
}


/*
@Builder
@Setter
@Getter
class CombinerResult{
    private User user;
    private Quiz quiz;
}
 */
