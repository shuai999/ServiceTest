package com.novate.usual.test03;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ================================================
 * Email: 2185134304@qq.com
 * Created by Novate 2018/12/7 9:23
 * Version 1.0
 * Params:
 * Description:    Parcelable实体类如下
 * ================================================
*/

public class Book implements Parcelable {

    private String bookName;
    private String author;
    private int publishTime;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.bookName);
        dest.writeString(this.author);
        dest.writeInt(this.publishTime);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.bookName = in.readString();
        this.author = in.readString();
        this.publishTime = in.readInt();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
