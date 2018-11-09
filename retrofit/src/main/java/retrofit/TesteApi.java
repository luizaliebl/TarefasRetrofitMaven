package retrofit;

import java.util.List;

import retrofit.Tarefa;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TesteApi {

	@Headers("Student: 1111008155")
	@GET("api/tasks")
	Call<List<Tarefa>> getTarefa();
	
	
	@Headers("Student: 1111008155")
	@GET("api/tasks/{id}")
	Call<Tarefa> getTarefa(@Path("id") int id);
	
	
	@Headers("Student: 1111008155")
	@POST("api/tasks")
	Call<Tarefa> setTarefa(@Body Tarefa description);

	
	@Headers("Student: 1111008155")
	@PUT("api/tasks/{id}")
	Call<Void> SetTarefa(@Path("id") int id, @Body Tarefa description);

	
	@Headers("Student: 1111008155")
	@DELETE("api/tasks/{id}")
	Call<Void> DelTarefa(@Path("id") int id);
}
