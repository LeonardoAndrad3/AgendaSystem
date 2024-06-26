package ivana.charis.agenda.domain.client;

public record ClientListDTO(

    Long id,
    String name,
    String email,
    String phone

){

    public ClientListDTO(Client client){
        this(client.getId(), client.getName(), client.getEmail(), client.getPhone());
    }
}
