package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    public final int numeroDeVagas = 10;
    List<Carro> estacionamento = new ArrayList<>();

    public void estacionar(Carro carro) {

        if(estacionamento.size()<10){
            estacionamento.add(carro);
        }

        if(estacionamento.size() == numeroDeVagas){
            Carro carroSair = estacionamento
                    .stream()
                    .filter(carroEstacionado -> carroEstacionado.getMotorista().getIdade()< 55)
                    .findFirst().orElseThrow(EstacionamentoException::new);
            estacionamento.remove(carroSair);
            estacionamento.add(carro);
        }
        ///////////////////SOLUCAO ANTERIOR AO JAVA8//////////////////////////
        //if(checaEstacionamento(carro)){
        //    System.out.println("Carro estacionado");
        //}else{
        //    throw new EstacionamentoException();
        //}
        ///////////////////SOLUCAO ANTERIOR AO JAVA8//////////////////////////
    }
    ///////////////////FUNCAO PARA SOLUCAO ANTERIOR AO JAVA8//////////////////
    //public boolean checaEstacionamento(Carro carro){
    //   for(int i = 0; i < estacionamento.size(); i++){
    //        for(Carro car : estacionamento){
    //            Motorista motor = car.getMotorista();
    //            if (motor.getIdade() < 55){
    //                estacionamento.remove(i);
    //                estacionamento.add(carro);
    //                return true;
    //            }
    //        }
    //    }
    //    return false;
    //}
    ///////////////////FUNCAO PARA SOLUCAO ANTERIOR AO JAVA8//////////////////

    public int carrosEstacionados(){
        return estacionamento.size();
    }

    public boolean carroEstacionado(Carro carro) {
        //return estacionamento
        //       .stream()
        //        .anyMatch(carroEstacionado -> carroEstacionado.equals(carro));
        return estacionamento.contains(carro);
    }
}
