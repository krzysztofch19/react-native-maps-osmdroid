package com.airbnb.android.react.maps;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.LatLng;

public class AirMapCircle2Manager2 extends ViewGroupManager<AirMapCircle2> {
  private final DisplayMetrics metrics;

  public AirMapCircle2Manager2(ReactApplicationContext reactContext) {
    super();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      metrics = new DisplayMetrics();
      ((WindowManager) reactContext.getSystemService(Context.WINDOW_SERVICE))
          .getDefaultDisplay()
          .getRealMetrics(metrics);
    } else {
      metrics = reactContext.getResources().getDisplayMetrics();
    }
  }

  @Override
  public String getName() {
    return "AirMapCircle2";
  }

  @Override
  public AirMapCircle2 createViewInstance(ThemedReactContext context) {
    return new AirMapCircle2(context);
  }

  @ReactProp(name = "center")
  public void setCenter(AirMapCircle2 view, ReadableMap center) {
    view.setCenter(new LatLng(center.getDouble("latitude"), center.getDouble("longitude")));
  }

  @ReactProp(name = "radius", defaultDouble = 0)
  public void setRadius(AirMapCircle2 view, double radius) {
    view.setRadius(radius);
  }

  @ReactProp(name = "strokeWidth", defaultFloat = 1f)
  public void setStrokeWidth(AirMapCircle2 view, float widthInPoints) {
    float widthInScreenPx = metrics.density * widthInPoints; // done for parity with iOS
    view.setStrokeWidth(widthInScreenPx);
  }

  @ReactProp(name = "fillColor", defaultInt = Color.RED, customType = "Color")
  public void setFillColor(AirMapCircle2 view, int color) {
    view.setFillColor(color);
  }

  @ReactProp(name = "strokeColor", defaultInt = Color.RED, customType = "Color")
  public void setStrokeColor(AirMapCircle2 view, int color) {
    view.setStrokeColor(color);
  }

  @ReactProp(name = "zIndex", defaultFloat = 1.0f)
  public void setZIndex(AirMapCircle2 view, float zIndex) {
    view.setZIndex(zIndex);
  }

}
