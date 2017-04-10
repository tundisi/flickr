package com.etermax.flickr.tests;

import android.support.test.runner.AndroidJUnit4;

import com.etermax.flickr.BaseTest;
import com.etermax.flickr.mock.MockResponse;
import com.etermax.flickr.ui.modules.detailPhoto.DetailPhotoPresenter;
import com.etermax.flickr.ui.modules.detailPhoto.DetailPhotoView;
import com.etermax.flickr.utils.Constant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import rx.Observable;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by Luis Tundisi on 09/04/2017.
 */

@RunWith(AndroidJUnit4.class)
public class DetailPresenterTest extends BaseTest {

    @Mock
    DetailPhotoView detailPhotoView;

    public DetailPhotoPresenter detailPhotoPresenter;

    @Override
    public void setMocks() {
        this.detailPhotoPresenter = new DetailPhotoPresenter(personController,detailPhotoView);
    }

    @Test
    public void getProfileById(){
        Mockito.when(personController.getProfileById(anyString())).thenReturn(Observable.just(MockResponse.getPersonResponse()).map(personResponse -> {

            assertEquals(personResponse.getPerson().getId(), Constant.DEFAULT_ID);
            assertEquals(personResponse.getPerson().getNsid(),Constant.DEFAULT_ID);
            assertEquals(personResponse.getPerson().getRealname().get_content(),Constant.DEFAULT_NAME);
            assertEquals(personResponse.getPerson().getUsername().get_content(),Constant.DEFAULT_NAME);

            return personResponse;
        }));
    }
}
