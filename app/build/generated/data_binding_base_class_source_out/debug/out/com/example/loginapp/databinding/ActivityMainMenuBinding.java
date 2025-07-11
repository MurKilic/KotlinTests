// Generated by view binder compiler. Do not edit!
package com.example.loginapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.loginapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainMenuBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText editTextBlock;

  @NonNull
  public final LinearLayout mainMenuLayout;

  @NonNull
  public final TextView mainMenuTitle;

  @NonNull
  public final RadioButton radioAktiv;

  @NonNull
  public final RadioButton radioDeaktiv;

  @NonNull
  public final RadioGroup radioGroup;

  @NonNull
  public final RadioButton radioNurLesen;

  private ActivityMainMenuBinding(@NonNull LinearLayout rootView, @NonNull EditText editTextBlock,
      @NonNull LinearLayout mainMenuLayout, @NonNull TextView mainMenuTitle,
      @NonNull RadioButton radioAktiv, @NonNull RadioButton radioDeaktiv,
      @NonNull RadioGroup radioGroup, @NonNull RadioButton radioNurLesen) {
    this.rootView = rootView;
    this.editTextBlock = editTextBlock;
    this.mainMenuLayout = mainMenuLayout;
    this.mainMenuTitle = mainMenuTitle;
    this.radioAktiv = radioAktiv;
    this.radioDeaktiv = radioDeaktiv;
    this.radioGroup = radioGroup;
    this.radioNurLesen = radioNurLesen;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.editTextBlock;
      EditText editTextBlock = ViewBindings.findChildViewById(rootView, id);
      if (editTextBlock == null) {
        break missingId;
      }

      LinearLayout mainMenuLayout = (LinearLayout) rootView;

      id = R.id.mainMenuTitle;
      TextView mainMenuTitle = ViewBindings.findChildViewById(rootView, id);
      if (mainMenuTitle == null) {
        break missingId;
      }

      id = R.id.radioAktiv;
      RadioButton radioAktiv = ViewBindings.findChildViewById(rootView, id);
      if (radioAktiv == null) {
        break missingId;
      }

      id = R.id.radioDeaktiv;
      RadioButton radioDeaktiv = ViewBindings.findChildViewById(rootView, id);
      if (radioDeaktiv == null) {
        break missingId;
      }

      id = R.id.radioGroup;
      RadioGroup radioGroup = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup == null) {
        break missingId;
      }

      id = R.id.radioNurLesen;
      RadioButton radioNurLesen = ViewBindings.findChildViewById(rootView, id);
      if (radioNurLesen == null) {
        break missingId;
      }

      return new ActivityMainMenuBinding((LinearLayout) rootView, editTextBlock, mainMenuLayout,
          mainMenuTitle, radioAktiv, radioDeaktiv, radioGroup, radioNurLesen);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
