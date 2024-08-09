package ivana.charis.agenda.domain.client;

public record ClientListDTO(

    Long id,
    String name

){

    public ClientListDTO(Client client){
        this(client.getId(), client.getName());
    }
}
