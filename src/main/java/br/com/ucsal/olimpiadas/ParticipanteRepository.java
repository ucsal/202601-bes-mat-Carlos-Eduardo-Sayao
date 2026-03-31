package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteRepository {
	private List<Participante> participantes = new ArrayList<>();
	
	public void salvarParticipante(Participante p) {
		participantes.add(p);
	}
	
	public List<Participante> listar(){
		return participantes;
	}
}
