package com.airbnb.android.react.maps;

import android.content.Context;

import com.facebook.react.views.view.ReactViewGroup;

public class AirMapCallout2 extends ReactViewGroup {
  private boolean tooltip = false;
  public int width;
  public int height;

  public AirMapCallout2(Context context) {
    super(context);
  }

  public void setTooltip(boolean tooltip) {
    this.tooltip = tooltip;
  }

  public boolean getTooltip() {
    return this.tooltip;
  }
}
