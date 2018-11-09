package retrofit;

import java.util.List;

import retrofit.Tarefa;
import retrofit.TesteApi;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

	public static void main(String[] args) {
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/")
			    .addConverterFactory(GsonConverterFactory.create())
			    .build();

			TesteApi api = retrofit.create(TesteApi.class);
			
			try {
				
				//GET/ID - Retorna uma única tarefa
				Call<Tarefa> callUnico = api.getTarefa(932);
				Response<Tarefa> responseUnico = callUnico.execute();
				Tarefa tarefaUnico = responseUnico.body();
				if (responseUnico.isSuccessful()) {
					System.out.println(tarefaUnico);
				}
				
				//GET - Retorna a lista com todas as tarefas
				Call<List<Tarefa>> callLista = api.getTarefa();
				Response<List<Tarefa>> responseLista = callLista.execute();
				List<Tarefa> tarefaLista = responseLista.body();
				if (responseLista.isSuccessful()) {
					System.out.println(tarefaLista);
				}
				
				//POST - Inclui uma nova tarefa
				Tarefa tarefaNew = new Tarefa();
				tarefaNew.setDescription("Nova tarefa!");
				tarefaNew.setDone(false);
                Call<Tarefa> newTarefa = api.setTarefa(tarefaNew);
                Response<Tarefa> responseNew = newTarefa.execute();
                Tarefa tarefasNew = responseNew.body();
                if (responseNew.isSuccessful()) {
                	Call<Tarefa> callUnic = api.getTarefa(tarefasNew.getId());
    				Response<Tarefa> responseUnic = callUnic.execute();
    				Tarefa tarefaUnic = responseUnic.body();
    				if (responseUnic.isSuccessful()) {
    					System.out.println(tarefaUnic);
    				}
                }
                
                //PUT - Altera uma tarefa
                Tarefa tarefaEdita = new Tarefa();
                tarefaEdita.setId(935);
                tarefaEdita.setDescription("Tarefa alterada");
                tarefaEdita.setDone(true);
                Call<Void> editaTarefa = api.SetTarefa(tarefaEdita.getId(), tarefaEdita);
                Response<Void> responseEdita = editaTarefa.execute();
                if (responseEdita.isSuccessful()) {
					System.out.println("Tarefa editada!");
				}
                
                //DELETE - Exclui uma tarefa
				Call<Void> delTarefa = api.DelTarefa(641);
				Response<Void> responseDel = delTarefa.execute();  
				if (responseDel.isSuccessful()) {
					System.out.println("Tarefa excluída!");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
