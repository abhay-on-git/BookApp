package com.example.boookapp;

public class bookModel {
    String image ;
    String pdfUrl;
    public bookModel(String image , String pdfUrl){
        this.image = image;
        this.pdfUrl = pdfUrl;
    }
    public bookModel(){}

    public String getImage() {
        return this.image;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setBook_img(String book_img) {
        this.image = image;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
