package com.siraj.todoapp.data;

import com.siraj.todoapp.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        try {
            if(username.equals("siraj") && password.equals("Suiiii@123")) {
                LoggedInUser loggedInUser =
                        new LoggedInUser(
                                java.util.UUID.randomUUID().toString(),
                                "Siraj Chaulagai");
                return new Result.Success<>(loggedInUser);
            }
            else {
                return new Result.Error(new IOException("Username and password does not match"));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
    }
}