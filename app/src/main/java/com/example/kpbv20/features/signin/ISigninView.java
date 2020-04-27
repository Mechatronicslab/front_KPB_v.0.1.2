package com.example.kpbv20.features.signin;

import com.example.kpbv20.features.signin.model.LoginResponse;

public interface ISigninView {
    void initViews();

    void goToRegist();

    void showLoadingIndicator();

    void hideLoadingIndicator();
}
