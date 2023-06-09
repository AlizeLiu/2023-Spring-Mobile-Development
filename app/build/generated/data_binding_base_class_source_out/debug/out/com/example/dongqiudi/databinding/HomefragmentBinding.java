// Generated by view binder compiler. Do not edit!
package com.example.dongqiudi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.dongqiudi.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class HomefragmentBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageButton delte;

  @NonNull
  public final ListView newsListView;

  @NonNull
  public final ImageButton update;

  private HomefragmentBinding(@NonNull LinearLayout rootView, @NonNull ImageButton delte,
      @NonNull ListView newsListView, @NonNull ImageButton update) {
    this.rootView = rootView;
    this.delte = delte;
    this.newsListView = newsListView;
    this.update = update;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static HomefragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static HomefragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.homefragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static HomefragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.delte;
      ImageButton delte = ViewBindings.findChildViewById(rootView, id);
      if (delte == null) {
        break missingId;
      }

      id = R.id.newsListView;
      ListView newsListView = ViewBindings.findChildViewById(rootView, id);
      if (newsListView == null) {
        break missingId;
      }

      id = R.id.update;
      ImageButton update = ViewBindings.findChildViewById(rootView, id);
      if (update == null) {
        break missingId;
      }

      return new HomefragmentBinding((LinearLayout) rootView, delte, newsListView, update);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
