package services;

import java.util.List;

import models.ImageResponse;
import models.ResponseData;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by zackhsi on 2/25/15.
 */
public interface ImageService {
    @GET("/images")
    void getImages(
            @Query("v") String version,
            @Query("rsz") int resultSize,
            @Query("imgsz") String size,
            @Query("imgcolor") String color,
            @Query("imgtype") String type,
            @Query("as_sitesearch") String site,
            @Query("q") String query,
            Callback<ImageResponse> callback
    );
}