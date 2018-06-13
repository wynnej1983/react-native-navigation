package com.reactnativenavigation.parse;

import com.reactnativenavigation.parse.params.Bool;
import com.reactnativenavigation.parse.params.NullBool;
import com.reactnativenavigation.parse.params.NullText;
import com.reactnativenavigation.parse.params.Text;
import com.reactnativenavigation.parse.parsers.BoolParser;
import com.reactnativenavigation.parse.parsers.TextParser;

import org.json.JSONObject;

public class BackButtonOptions {
    public static BackButtonOptions parse(JSONObject json) {
        BackButtonOptions result = new BackButtonOptions();
        if (json == null) return result;

        result.visible = BoolParser.parse(json, "visible");
        result.icon = TextParser.parse(json.optJSONObject("icon"), "uri");

        return result;
    }

    public Text icon = new NullText();
    public Bool visible = new NullBool();

    public void mergeWith(BackButtonOptions other) {
        if (other.icon.hasValue()) icon = other.icon;
        if (other.visible.hasValue()) visible = other.visible;
    }

    void mergeWithDefault(final BackButtonOptions defaultOptions) {
        if (!icon.hasValue()) icon = defaultOptions.icon;
        if (!visible.hasValue()) visible = defaultOptions.visible;
    }
}
