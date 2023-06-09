// Generated by view binder compiler. Do not edit!
package com.example.dongqiudi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dongqiudi.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddNewsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button button;

  @NonNull
  public final EditText etcon;

  @NonNull
  public final EditText etid;

  @NonNull
  public final EditText ettit;

  @NonNull
  public final Button findbtn;

  private ActivityAddNewsBinding(@NonNull LinearLayout rootView, @NonNull Button button,
      @NonNull EditText etcon, @NonNull EditText etid, @NonNull EditText ettit,
      @NonNull Button findbtn) {
    this.rootView = rootView;
    this.button = button;
    this.etcon = etcon;
    this.etid = etid;
    this.ettit = ettit;
    this.findbtn = findbtn;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddNewsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddNewsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_news, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddNewsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.etcon;
      EditText etcon = ViewBindings.findChildViewById(rootView, id);
      if (etcon == null) {
        break missingId;
      }

      id = R.id.etid;
      EditText etid = ViewBindings.findChildViewById(rootView, id);
      if (etid == null) {
        break missingId;
      }

      id = R.id.ettit;
      EditText ettit = ViewBindings.findChildViewById(rootView, id);
      if (ettit == null) {
        break missingId;
      }

      id = R.id.findbtn;
      Button findbtn = ViewBindings.findChildViewById(rootView, id);
      if (findbtn == null) {
        break missingId;
      }

      return new ActivityAddNewsBinding((LinearLayout) rootView, button, etcon, etid, ettit,
          findbtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
