package mx.com.dhaggher.examplemvvmdatabinding.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Patterns;

import com.android.databinding.library.baseAdapters.BR;

import mx.com.dhaggher.examplemvvmdatabinding.model.StatusMessage;
import mx.com.dhaggher.examplemvvmdatabinding.model.User;

/**
 * Created by Gerardo Ramon on 3/17/19.
 */
public class LoginViewModel extends BaseObservable {
    private User user;

    public LoginViewModel() {
        user = new User("","");
    }

    //private String toastMessage;

    private StatusMessage statusMessage;

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPass();
    }

    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    public void setUserPassword(String password) {
        user.setPass(password);
        notifyPropertyChanged(BR.userPassword);
    }

    private boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail())
                .matches() && getUserPassword().length() > 5;
    }

    /*@Bindable
    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void onLoginClicked() {
        if (isInputDataValid())
            setToastMessage("");
        else
            setToastMessage("");
    }*/

    @Bindable
    public StatusMessage getStatusMessage() {
        return statusMessage;
    }

    private void setStatusMessage(StatusMessage statusMessage) {
        this.statusMessage = statusMessage;
        notifyPropertyChanged(BR.statusMessage);
    }

    public void onLoginClicked() {
        if (isInputDataValid())
            setStatusMessage(StatusMessage.SUCCESS_LOGIN);
        else
            setStatusMessage(StatusMessage.FAIL_LOGIN);
    }
}
