package com.etermax.flickr.tests;

import android.support.test.runner.AndroidJUnit4;

import com.etermax.flickr.BaseTest;
import com.etermax.flickr.mock.MockResponse;
import com.etermax.flickr.ui.modules.profile.ProfileFragmentPresenter;
import com.etermax.flickr.ui.modules.profile.ProfileFragmentView;
import com.etermax.flickr.utils.Constant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import rx.Observable;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by Luis Tundisi on 09/04/2017.
 */

@RunWith(AndroidJUnit4.class)
public class ProfilePresenterTest extends BaseTest {

    @Mock
    ProfileFragmentView profileFragmentView;

    public ProfileFragmentPresenter profileFragmentPresenter;

    @Override
    public void setMocks() {
        this.profileFragmentPresenter = new ProfileFragmentPresenter(photosController,profileFragmentView);
    }

    @Test
    public void getPhotosByIdPerson(){

        Mockito.when(photosController.getPhotosByIdPerson(anyString(),anyInt()))
                .thenReturn(Observable.just(MockResponse.getPhotosResponse()).map(photosResponse -> {
                    assertEquals(photosResponse.getPhotos().getPages(), Constant.MAX_PAGES);
                    assertEquals(photosResponse.getPhotos().getPage(),Constant.DEFAULT_PAGE);
                    assertEquals(photosResponse.getPhotos().getPerpage(), Constant.PER_PAGE);

                    for(int i = 0; i < Integer.parseInt(Constant.PER_PAGE); i++){
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getId(),String.valueOf(i));
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getTitle(),Constant.DEFAULT_TITLE);
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getFarm(),Constant.DEFAULT_FARM);
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getIsfamily(),Constant.DEFAULT_IS_FAMILY);
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getIsfriend(),Constant.DEFAULT_IS_FRIEND);
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getIspublic(),Constant.DEFAULT_IS_PUBLIC);
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getSecret(),Constant.DEFAULT_SECRET);
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getServer(),Constant.DEFAULT_SERVER);
                        assertEquals(photosResponse.getPhotos().getPhoto().get(i).getOwner(),Constant.DEFAULT_OWNER);
                    }
                    return photosResponse;
                }));

        profileFragmentPresenter.getPhotosByIdPerson(Constant.DEFAULT_ID,Constant.DEFAULT_PAGE);
    }

    @Test
    public void getPhotosById(){

        Mockito.when(photosController.getPhotoById(anyString()))
                .thenReturn(Observable.just(MockResponse.getPhotoDetailResponse()).map(photosResponse -> {

                    assertEquals(photosResponse.getPhoto().getId(),Constant.DEFAULT_ID);
                    assertEquals(photosResponse.getPhoto().getServer(),Constant.DEFAULT_SERVER);
                    assertEquals(photosResponse.getPhoto().getSecret(),Constant.DEFAULT_SECRET);
                    assertEquals(photosResponse.getPhoto().getFarm(),Constant.DEFAULT_FARM);

                    return photosResponse;
                }));

        profileFragmentPresenter.getPhotosById(Constant.DEFAULT_ID);
    }

}
