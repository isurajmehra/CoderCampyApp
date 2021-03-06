package com.gmonetix.codercampy.networking;

import com.gmonetix.codercampy.model.Blog;
import com.gmonetix.codercampy.model.BlogDiscussion;
import com.gmonetix.codercampy.model.BlogRating;
import com.gmonetix.codercampy.model.Category;
import com.gmonetix.codercampy.model.Course;
import com.gmonetix.codercampy.model.CourseDiscussion;
import com.gmonetix.codercampy.model.CourseRating;
import com.gmonetix.codercampy.model.HomeData;
import com.gmonetix.codercampy.model.Instructor;
import com.gmonetix.codercampy.model.Language;
import com.gmonetix.codercampy.model.Name;
import com.gmonetix.codercampy.model.Rating;
import com.gmonetix.codercampy.model.Response;
import com.gmonetix.codercampy.model.User;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Gaurav Bordoloi on 2/28/2018.
 */

public interface APIInterface {

    @FormUrlEncoded
    @POST("/upload.php")
    Call<Response> uploadImage(@Field("image") String base64Image, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("/add-fav")
    Call<Response> addFav(@Field("course_id") String course_id, @Field("uid") String uid);

    @FormUrlEncoded
    @POST("/remove-fav")
    Call<Response> removeFav(@Field("course_id") String course_id, @Field("uid") String uid);

    @POST("/add-user")
    Call<Response> createUser(@Body User user);

    @FormUrlEncoded
    @POST("/course-rating")
    Call<Response> addCourseRating(@Field("course_id") String course_id, @Field("uid") String uid, @Field("rating") int rating, @Field("message") String message);

    @FormUrlEncoded
    @POST("/blog-rating")
    Call<Response> addBlogRating(@Field("blog_id") String blog_id, @Field("uid") String uid, @Field("rating") int rating, @Field("message") String message);

    @FormUrlEncoded
    @POST("/course-discussion")
    Call<Response> addCourseDiscussion(@Field("course_id") String course_id, @Field("uid") String uid, @Field("message") String message);

    @FormUrlEncoded
    @POST("/blog-discussion")
    Call<Response> addBlogDiscussion(@Field("blog_id") String blog_id, @Field("uid") String uid, @Field("message") String message);

    @GET("/user-uid/{uid}")
    Call<User> getUser(@Path("uid") String uid);

    @GET("/name/{uid}")
    Call<Name> getUserNameByUid(@Path("uid") String uid);

    @GET("/instructors")
    Call<List<Instructor>> getAllInstructors();

    @GET("/home-data")
    Call<HomeData> getHomeData();

    @GET("/instructor/{id}")
    Call<Instructor> getInstructor(@Path("id") String id);

    @GET("/courses/{offset}&{limit}")
    Call<List<Course>> getAllCourses(@Path("offset") int offset,@Path("limit") int limit,@Query("exclude") String exclude);

    @GET("/courses/{ids}")
    Call<List<Course>> getCourses(@Path("ids") String ids);

    @GET("/instructor-search/{instructorId}")
    Call<List<Course>> getCoursesByInstructorId(@Path("instructorId") String instructorId);

    @GET("/course/{id}")
    Call<Course> getCourse(@Path("id") String id);

    @GET("/languages")
    Call<List<Language>> getAllLanguages();

    @GET("/language/{id}")
    Call<Language> getLanguage(@Path("id") String id);

    @GET("/languages/{ids}")
    Call<List<Language>> getLanguages(@Path("ids") String ids);

    @GET("/categories")
    Call<List<Category>> getAllCategories();

    @GET("/category/{id}")
    Call<Category> getCategory(@Path("id") String id);

    @GET("/categories/{ids}")
    Call<List<Category>> getCategories(@Path("ids") String ids);

    @GET("/blogs")
    Call<List<Blog>> getAllBlogs();

    @GET("/blog/{id}")
    Call<Blog> getBlog(@Path("id") String id);

    @GET("/discussions/course/{id}&{offset}&{limit}")
    Call<CourseDiscussion> getCourseDiscussionsById(@Path("id") String id,@Path("offset") int offset,@Path("limit") int limit);

    @GET("/discussions/blog/{id}&{offset}&{limit}")
    Call<BlogDiscussion> getBlogDiscussionsById(@Path("id") String id,@Path("offset") int offset,@Path("limit") int limit);

    @GET("/ratings/course/{id}&{offset}&{limit}")
    Call<CourseRating> getCourseRatingsById(@Path("id") String id,@Path("offset") int offset,@Path("limit") int limit);

    @GET("/ratings/blog/{id}&{offset}&{limit}")
    Call<BlogRating> getBlogRatingsById(@Path("id") String id,@Path("offset") int offset,@Path("limit") int limit);

}
