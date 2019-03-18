package mx.com.dhaggher.examplemvvmdatabinding.view;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import mx.com.dhaggher.examplemvvmdatabinding.R;
import mx.com.dhaggher.examplemvvmdatabinding.databinding.ActivityMainBinding;
import mx.com.dhaggher.examplemvvmdatabinding.model.StatusMessage;
import mx.com.dhaggher.examplemvvmdatabinding.utils.Utils;
import mx.com.dhaggher.examplemvvmdatabinding.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new LoginViewModel());
        binding.executePendingBindings();
        binding.buttonLogin.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || (event != null
                && (event.getKeyCode() == EditorInfo.IME_ACTION_DONE
                || event.getKeyCode() == KeyEvent.KEYCODE_ENTER
                || event.getKeyCode() == KeyEvent.FLAG_EDITOR_ACTION))
        ) {
            Utils.hideKeyboard(this);
        }
        return true;
    }

    /*@BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null) {
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }*/

    @BindingAdapter({"statusMessage"})
    public static  void showMe(View view, StatusMessage statusMessage) {
        if (statusMessage == StatusMessage.SUCCESS_LOGIN)
            Snackbar.make(view, R.string.message_success_login, Snackbar.LENGTH_LONG).show();
        else
            Snackbar.make(view, R.string.message_fail_login, Snackbar.LENGTH_LONG).show();
    }
}
