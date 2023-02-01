package in.reqres.Dados;


public class DadosUsuario {

    /**
     *  Classe que contém os dados de usuário
     */
    private String name;
    private String job;
    
    public DadosUsuario(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    
}
