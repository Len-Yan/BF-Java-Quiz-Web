package com.quizendpoint.response;

import com.quizendpoint.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AllUserResponse {
    private List<User> userList;
}
