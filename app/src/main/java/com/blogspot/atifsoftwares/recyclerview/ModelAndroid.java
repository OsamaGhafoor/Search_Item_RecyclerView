package com.blogspot.atifsoftwares.recyclerview;

public class ModelAndroid {
    String versionName, apiLevel, versionDescription;
    int image;

    public ModelAndroid(String versionName, String apiLevel, String versionDescription, int image) {
        this.versionName = versionName;
        this.apiLevel = apiLevel;
        this.versionDescription = versionDescription;
        this.image = image;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(String apiLevel) {
        this.apiLevel = apiLevel;
    }

    public String getVersionDescription() {
        return versionDescription;
    }

    public void setVersionDescription(String versionDescription) {
        this.versionDescription = versionDescription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
