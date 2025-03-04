package ivana.charis.agenda.domain.service;

public enum Status {

    ENVIADO(0),PROCESSANDO(1),CONCLUIDO(2),REVISANDO(3);

    private int cod;

    Status(int cod){
        this.cod = cod;
    }

    public int getCod(){
        return cod;
    }


}
