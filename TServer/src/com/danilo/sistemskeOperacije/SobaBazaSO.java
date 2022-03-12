package com.danilo.sistemskeOperacije;


import java.util.List;

import com.danilo.broker.Broker;
import com.danilo.broker.IBroker;
import com.danilo.domen.OpstiDomen;
import com.danilo.domen.Soba;

public class SobaBazaSO extends OpstaSistemskaOperacija {

	@Override
	protected void izvrsiKonkretnuOperacije(Object object) {
		List<OpstiDomen> sobaBaza = (List<OpstiDomen>) object;
		IBroker ib = new Broker();
		sobaBaza.addAll( ib.vratiPoslednjiPodatakBaza(new Soba()));

	}

}
