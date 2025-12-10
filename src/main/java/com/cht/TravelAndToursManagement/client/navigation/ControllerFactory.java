package com.cht.TravelAndToursManagement.client.navigation;

import javafx.util.Callback;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory implements Callback<Class<?>, Object> {
    private final Map<Class<?>, Object> controllers = new HashMap<>();

    public void registerController(Class<?> controllerClass, Object instance) {
        controllers.put(controllerClass, instance);
    }

    @Override
    public Object call(Class<?> controllerClass) {
        return controllers.get(controllerClass);
    }
}
