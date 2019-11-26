package com.example.Models;

public class UploadDocumentsModel {

    String ParentName;
    private boolean expanded;

    public UploadDocumentsModel(String parentName) {
        ParentName = parentName;
    }

    public String getParentName() {
        return ParentName;
    }
}
