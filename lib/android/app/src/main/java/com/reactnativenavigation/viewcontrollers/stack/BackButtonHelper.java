package com.reactnativenavigation.viewcontrollers.stack;

import com.reactnativenavigation.parse.Options;
import com.reactnativenavigation.parse.params.Button;
import com.reactnativenavigation.react.Constants;
import com.reactnativenavigation.viewcontrollers.ViewController;

import java.util.ArrayList;
import java.util.Collections;

public class BackButtonHelper {

    public void addToChild(StackController stack, ViewController child) {
        if (stack.size() <= 1 || child.options.topBar.leftButtons != null) return;
        Options options = new Options();
        Button back = new Button();
        back.id = Constants.BACK_BUTTON_ID;
        options.topBar.leftButtons = new ArrayList<>(Collections.singleton(back));
        child.mergeOptions(options);
    }
}
