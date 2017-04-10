package com.etermax.flickr.mock;

import com.etermax.flickr.data.models.Comments;
import com.etermax.flickr.data.models.Dates;
import com.etermax.flickr.data.models.Description;
import com.etermax.flickr.data.models.Person;
import com.etermax.flickr.data.models.Photo;
import com.etermax.flickr.data.models.PhotoDetail;
import com.etermax.flickr.data.models.Photos;
import com.etermax.flickr.data.models.Realname;
import com.etermax.flickr.data.models.Tag;
import com.etermax.flickr.data.models.Tags;
import com.etermax.flickr.data.models.Title;
import com.etermax.flickr.data.models.Usage;
import com.etermax.flickr.data.models.Username;
import com.etermax.flickr.data.response.PersonResponse;
import com.etermax.flickr.data.response.PhotoDetailResponse;
import com.etermax.flickr.data.response.PhotosResponse;
import com.etermax.flickr.utils.Constant;

import java.util.ArrayList;

/**
 * Created by Luis Tundisi on 08/04/2017.
 */

public class MockResponse {

    public static PhotosResponse getPhotosResponse(){
        PhotosResponse photosResponse = new PhotosResponse();

        Photos photos = new Photos();

        ArrayList<Photo> photoArrayList = new ArrayList<>();

        photos.setPage(Constant.DEFAULT_PAGE);
        photos.setPages(Constant.MAX_PAGES);
        photos.setPerpage(Integer.parseInt(Constant.PER_PAGE));

        Photo photo;
        for(int i = 0; i < Integer.parseInt(Constant.PER_PAGE); i++) {
            photo = new Photo();
            photo.setTitle(Constant.DEFAULT_TITLE);
            photo.setFarm(Constant.DEFAULT_FARM);
            photo.setId(String.valueOf(i));
            photo.setIsfamily(Constant.DEFAULT_IS_FAMILY);
            photo.setIsfriend(Constant.DEFAULT_IS_FRIEND);
            photo.setIspublic(Constant.DEFAULT_IS_PUBLIC);
            photo.setSecret(Constant.DEFAULT_SECRET);
            photo.setServer(Constant.DEFAULT_SERVER);
            photo.setOwner(Constant.DEFAULT_OWNER);
            photoArrayList.add(photo);
        }

        photos.setPhoto(photoArrayList);
        photosResponse.setPhotos(photos);
        return photosResponse;
    }

    public static PhotoDetailResponse getPhotoDetailResponse(){
        PhotoDetailResponse photoDetailResponse = new PhotoDetailResponse();

        PhotoDetail photoDetail = new PhotoDetail();
        photoDetail.setTitle(new Title(Constant.DEFAULT_TITLE));
        photoDetail.setFarm(Constant.DEFAULT_FARM);
        photoDetail.setId(String.valueOf(Constant.DEFAULT_ID));
        photoDetail.setSecret(Constant.DEFAULT_SECRET);
        photoDetail.setServer(Constant.DEFAULT_SERVER);


        photoDetail.setDescription(new Description(Constant.DEFAULT_DESCRIPTION));
        photoDetail.setDates(new Dates("","",""));
        photoDetail.setViews("");
        photoDetail.setUsage(new Usage(0,0,0));
        photoDetail.setComments(new Comments(0));
        photoDetail.setTags(new Tags(new ArrayList<Tag>()));

        photoDetailResponse.setPhoto(photoDetail);
        return photoDetailResponse;
    }

    public static PersonResponse getPersonResponse(){
        PersonResponse personResponse = new PersonResponse();

        Person person = new Person();
        person.setNsid(Constant.DEFAULT_ID);
        person.setUsername(new Username(Constant.DEFAULT_NAME));
        person.setRealname(new Realname(Constant.DEFAULT_NAME));
        person.setDescription(new Description(Constant.DEFAULT_DESCRIPTION));
        person.setId(Constant.DEFAULT_ID);

        personResponse.setPerson(person);

        return personResponse;
    }
}
