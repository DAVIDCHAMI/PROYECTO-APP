package com.example.u12.arquitecturamvp.views.interfeces;

import com.example.u12.arquitecturamvp.views.IBaseView;

public interface IMainView extends IBaseView {

    void showResult(int result);

    void showMessageLocalContact(boolean success);
}
