package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

import static java.util.Comparator.comparing;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> times = new ArrayList<>();
	List<Jogador> jogadores = new ArrayList<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////INICIO DOS SISTEMAS DE BUSCA////////////////////////////////////////////////
	private void checaSeTimeExiste(Long id){
		if(times.stream().anyMatch(time -> time.getId().equals(id))){
			throw new IdentificadorUtilizadoException();
		}
	}

	private void checaSeJogadorExiste(Long id){
		if(jogadores.stream().anyMatch(jogador -> jogador.getId().equals(id))){
			throw  new IdentificadorUtilizadoException();
		}
	}

	private void buscarTime(Long idTime) {
		if(!times.stream().anyMatch(time -> time.getId().equals(idTime))){
			throw new TimeNaoEncontradoException();
		}
	}

	private Time buscarTimePorIdJogador(Long id){
		Jogador jogador = jogadores.stream()
				.filter(cadaJogador -> cadaJogador.getId().equals(id))
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);
		Time time = times.stream()
				.filter(cadaTime -> cadaTime.getId().equals(jogador.getIdTime()))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);
		return time;
	}

	private Time filtroDeTime(Long idTime){
		return times.stream()
				.filter(cadaTime-> cadaTime.getId().equals(idTime))
				.findFirst()
				.orElseThrow(TimeNaoEncontradoException::new);
	}

	private Jogador filtroDeJogador(Long idJogador){
		return jogadores.stream()
				.filter(cadaJogador -> cadaJogador.getId().equals(idJogador))
				.findFirst()
				.orElseThrow(JogadorNaoEncontradoException::new);
	}

	private void timeTemCapitao(Long idDoCapitao){
		if(idDoCapitao == null){
			throw new CapitaoNaoInformadoException();
		}
	}

	private List<Jogador> filtrarJogadoresDoTime(Long idTime){
		return jogadores.stream().filter(p->p.getIdTime().equals(idTime)).collect(Collectors.toList());
	}

	////////////////////////////////////////////FINAL DOS SISTEMAS DE BUSCA/////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////INICIO DOS METODOS DA CLASSE////////////////////////////////////////////
	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		checaSeTimeExiste(id);
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		times.add(time);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		checaSeJogadorExiste(id);
		buscarTime(idTime);
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		jogadores.add(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Time time = buscarTimePorIdJogador(idJogador);
		time.setCapitao(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time = filtroDeTime(idTime);
		timeTemCapitao(time.getCapitao());
		return time.getCapitao();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = filtroDeJogador(idJogador);
		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		Time time = filtroDeTime(idTime);
		return time.getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		////////USANDO SINTAXE ANTERIOR AO JAVA8//////////
		buscarTime(idTime);
		List<Long> ids = new ArrayList<>();
		for(Jogador jogador: jogadores){
			if(jogador.getIdTime().equals(idTime)){
				ids.add(jogador.getId());
			}
		}
		return ids;
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		buscarTime(idTime);
		List<Jogador> jgs = filtrarJogadoresDoTime(idTime);
		//jgs.forEach(System.out::println);
		Jogador maxJogador = jgs
				.stream()
				.max(comparing(Jogador::getNivelHabilidade))
				.orElseThrow(TimeNaoEncontradoException::new);
		return  maxJogador.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		buscarTime(idTime);
		List<Jogador> jgs = filtrarJogadoresDoTime(idTime);
		Jogador maxVelho = jgs.stream()
				.min(comparing(Jogador::getDataNascimento))
				.orElseThrow(TimeNaoEncontradoException::new);
		return maxVelho.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return times.stream().map(res -> res.getId()).collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		buscarTime(idTime);
		List<Jogador> jgs = filtrarJogadoresDoTime(idTime);
		Jogador jogador = jgs.stream()
				.max(comparing(Jogador::getSalario))
				.orElseThrow(TimeNaoEncontradoException::new);
		return jogador.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = filtroDeJogador(idJogador);
		return jogador.getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores.stream()
				.sorted(comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
				.limit(top)
				.map(Jogador::getId)
				.collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time time1 = filtroDeTime(timeDaCasa);
		Time time2 = filtroDeTime(timeDeFora);
		if(time1.getCorUniformePrincipal().equals(time2.getCorUniformePrincipal())){
			return time2.getCorUniformeSecundario();
		}
		else{
			return time2.getCorUniformePrincipal();
		}
	}
	////////////////////////////////////////////FINAL DOS METODOS DA CLASSE////////////////////////////////////////////
}
